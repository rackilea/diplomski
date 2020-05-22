@ DynamoDBTable(tableName = "AlarmTable")
public class VideoDynamoMappingAdapter {

    private String videoID;
    private String videoCategory;
    private String videoArtist;
    private String videoTitle;

    @DynamoDBHashKey(attributeName = "ID")
    public String getVideoID() {
        return videoID;
    }

    public void setVideoID(String videoID) {
        this.videoID = videoID;
    }

    @DynamoDBIndexHashKey( globalSecondaryIndexName = "CategoryIndex", attributeName = "Category")
    public String getVideoCategory() {
        return videoCategory;
    }

    public void setVideoCategory(String videoCategory) {
        this.videoCategory = videoCategory;
    }

    @DynamoDBAttribute(attributeName = "VideoArtist")
    public String getVideoArtist() {
        return videoArtist;
    }

    public void setVideoArtist(String videoArtist) {
        this.videoArtist = videoArtist;
    }

    @DynamoDBAttribute(attributeName = "VideoTitle")
    public String getVideoTitle() {
        return videoTitle;
    }

    public void setVideoTitle(String videoTitle) {
        this.videoTitle = videoTitle;
    }

}