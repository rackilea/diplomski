interface service {
    @GET("/muzei.php")
    Map<String,Photo> getPopularPhotos();

    static class Photo {
        int id;
        String user;
        String title;
        String url;

    }
}