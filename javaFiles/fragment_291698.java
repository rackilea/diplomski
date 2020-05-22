try {

    ZipOutputStream zip = new ZipOutputStream(new FileOutputStream("C:/archive.zip"));

    //GetImgURLs() is however you get your image URLs

    for(URL imgURL : GetImgURLs()) {
        is = imgURL.openStream();
        zip.putNextEntry(new ZipEntry(imgURL.getFile()));
        int length;

        byte[] b = new byte[2048];

        while((length = is.read(b)) > 0) {
            zip.write(b, 0, length);
        }
        zip.closeEntry();
        is.close();
    }
    zip.close();
}