@Override
protected Void doInBackground(Void... params) {

    try {
        Document document = Jsoup.connect(url).get();
        Elements img = document.select("div[class=logo_top] img[src]");
        String imgSrc = img.attr("src");
        // imgSrc may not be full path
        if(!imgSrc.startsWith(url)) {
            // create full path
            imgSrc = url+imgSrc;
        }
        InputStream input = new URL(imgSrc).openStream();
        bitmap = BitmapFactory.decodeStream(input);

    } catch (IOException e) {
        e.printStackTrace();
    }
    return null;
}