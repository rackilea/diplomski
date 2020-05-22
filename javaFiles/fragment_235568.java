for(Element img : document.select("div.news-col-0 img[src]")) {
    String ImgSrc = img.attr("src");
    // Download image from URL
    InputStream is = new java.net.URL(ImgSrc).openStream();
    bitmap = BitmapFactory.decodeStream(is);
 }