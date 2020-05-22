public static double[] createArrFromIm(BufferedImage im){
    int imWidth = im.getWidth();
    int imHeight = im.getHeight();
    double[] imArr = new double[imWidth* imHeight];
    for (int y=0, nb=0 ; y < imHeight ; y++)
        for (int x=0 ; x < imWidth ; x++, nb++)
            imArr[nb] = im.getRaster().getSampleDouble(x, y, 0) ;
    return imArr;
}