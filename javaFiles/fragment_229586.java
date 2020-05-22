public class ExampleParser {
    public static final String JSONC =
        "{\"apiVersion\":\"2.1\","
            + "   \"data\":{"
            + "       \"id\":\"iS1g8G_njx8\","
            + "       \"uploaded\":\"2014-05-30T20:00:01.000Z\","
            + "       \"updated\":\"2014-11-26T14:14:11.000Z\","
            + "       \"uploader\":\"arianagrandevevo\","
            + "       \"category\":\"Music\","
            + "       \"title\":\"Ariana Grande - Problem ft. Iggy Azalea\","
            + "       \"description\":\"Ariana Grande ft. Iggy Azalea - Problem\nBuy now! http://smarturl.it/ArianaMyEvrythnDlxiT?IQid=vevo.cta.problem\nGoogle Play: http://goo.gl/n7rey5\n\nPre-order My Everything and get access to the iHeartRadio Concert video stream where Ariana performs songs from her new album FOR THE FIRST TIME!\nhttp://myplay.me/19ys\","
            + "       \"thumbnail\":{"
            + "           \"sqDefault\":\"http://i.ytimg.com/vi/iS1g8G_njx8/default.jpg\","
            + "           \"hqDefault\":\"http://i.ytimg.com/vi/iS1g8G_njx8/hqdefault.jpg\"},"
            + "       \"player\":{"
            + "           \"default\":\"http://www.youtube.com/watch?v=iS1g8G_njx8&feature=youtube_gdata_player\"},"
            + "       \"content\":{"
            + "           \"5\":\"http://www.youtube.com/v/iS1g8G_njx8?version=3&f=videos&app=youtube_gdata\"},"
            + "           \"duration\":208," 
            + "           \"aspectRatio\":\"widescreen\"," 
            + "           \"rating\":4.731269," 
            + "           \"likeCount\":\"1527921\"," 
            + "           \"ratingCount\":1637964," 
            + "           \"viewCount\":307368910," 
            + "           \"favoriteCount\":0," 
            + "           \"commentCount\":156682," 
            + "           \"status\":{" 
            + "               \"value\":\"restricted\"," 
            + "               \"reason\":\"limitedSyndication\"}," 
            + "           \"restrictions\":[" 
            + "               {\"type\":\"country\"," 
            + "                \"relationship\":\"deny\"," 
            + "                \"countries\":\"DE\"}]," 
            + "           \"accessControl\":{" 
            + "               \"comment\":\"allowed\"," 
            + "               \"commentVote\":\"allowed\"," 
            + "               \"videoRespond\":\"moderated\"," 
            + "               \"rate\":\"allowed\"," 
            + "               \"embed\":\"allowed\"," 
            + "               \"list\":\"allowed\"," 
            + "               \"autoPlay\":\"allowed\"," 
            + "               \"syndicate\":\"allowed\"}}}";

   public static void main(String[] args) {
        Gson gson = new GsonBuilder()
                // Add your date deserializer
                .create();
        YoutubeResponse response = gson.fromJson(JSONC, YoutubeResponse.class);
        System.out.println(response);
    }

    public static class YoutubeResponse {
        Double apiVersion;
        Data data;
    }

    public static class Data {
        String id;
        String uploaded; // TODO should be a date
        String updated; // TODO should be a date
        String uploader;
        String category;
        String title;
        String description;
        Thumbnail thumbnail;
        Player player;
        Integer duration;
        String aspectRatio;
        Double rating;
        Integer likeCount;
        Integer ratingCount;
        Integer viewCount;
        Integer favoriteCount;
        Integer commentCount;
        Status status;
        List<Restriction> restrictions;
    }

    public static class Thumbnail {
        String sqDefault;
        String hqDefault;
    }

    public static class Player {
        @SerializedName("default")
        String defaultt; // default is a reserved java keyword
    }

    public static class Status {
        String value;
        String reason;
    }

    public static class Restriction {
        String type;
        String relationship;
        String countries;
    }

    public static class AccessControl {
        String comment;
        String commentVote;
        String videoRespond;
        String rate;
        String embed;
        String list;
        String autoPlay;
        String syndicate;
    }
}