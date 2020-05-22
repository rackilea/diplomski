String[] images = Parse_imgJSON.image;
        for (int i = 0; i < images.length; i++) {
            Log.d("Image ", images[i]);
            download_img(images[i], i);
        }




 public void download_img(String img_url, int i) {
        String fileName = img_url.substring(img_url.lastIndexOf('/') + 1, img_url.length());
        File file = new File("/storage/emulated/0/rready_images/" + fileName);

        if (file.exists() && !file.isDirectory()) {
            Log.d("Image exists", fileName);



            } else {
                if (fileName.contains(".jpg") || fileName.contains(".gif") || fileName.contains(".png")) {
                    new DownloadImagesAsync(i, new MyCallback() {
@Override
    public void readycallback(int index_thread) {

    //this is your ready callback

    }
    }).execute(img_url);
                } else {
                    Log.d("IMAGE DOWNLOAD ", "FAILED FOR " + fileName);

                }

            }
    }