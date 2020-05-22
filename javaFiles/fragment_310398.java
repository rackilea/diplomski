public static void main(String[] args) {

    String key="#########";
    String tag = "ballad";
    int limit = 100;
    int page = 2;
    int i = 1;

    Chart<Artist> I3 = Tag.getWeeklyArtistChart(tag, page, key); // You can also set the limit here. (optional)
    Iterable<Artist> tag3 = I3.getTopArtists(page, limit, key); // Try to add the limit here. (optional)(Default 50)


    for (Artist artist : tag3) {
        System.out.println("["+i+"]"+""+artist.getName());
        i++;
    }
}