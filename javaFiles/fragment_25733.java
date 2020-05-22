for(Element picture : document.select(".rullo .rullo-item picture")) {
    Elements imageElement = picture.getElementsByClass("attachment-rullo");
    String imageUrl = imageElement.attr("data-src");
    if(imageUrl == null || imageUrl.equals("")){
        images.add(bmp);
    } else {
        try{
            InputStream input = new java.net.URL(imageUrl).openStream();
            Bitmap bitmap = BitmapFactory.decodeStream(input);
            images.add(bitmap);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            images.add(bmp);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            images.add(bmp);
        }
    }
}