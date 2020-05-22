Uri uri = new Uri.Builder()
    .scheme("http")
    .authority("www.youtube-mp3.org")
    .path("/a/pushItem/")
    .appendQueryParameter("item", "http://www.youtube.com/watch?v=xo9EV3A4oaA")
    .appendQueryParameter("xy", "yx")
    .build();