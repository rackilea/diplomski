public void getSpace(Mat mat) {
    this.mat = mat;
    int w = mat.cols(), h = mat.rows();
    if (dat == null || dat.length != w * h * 3)
        dat = new byte[w * h * 3];
    if (img == null || img.getWidth() != w || img.getHeight() != h || img.getType() != BufferedImage.TYPE_3BYTE_BGR)
        img = new BufferedImage(w, h, BufferedImage.TYPE_3BYTE_BGR);


}

BufferedImage getImage(Mat mat) {
    getSpace(mat);
    mat.get(0, 0, dat);

    for (int i = 0; i < dat.length; i+= 3) {
        byte redChannel = dat[i];
        byte blueChannel = dat[i+2];

        dat[i] = blueChannel;
        dat[i+2] = redChannel;

    }
    img.getRaster().setDataElements(0, 0, mat.cols(), mat.rows(), dat);
    return img;
}