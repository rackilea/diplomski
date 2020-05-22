for (int i = 0; i < matrix.length; i++) {
    for (int j = 0; j < matrix[0].length; j++) {
        int c=(int) (matrix[i][j]*255.0/1000.0);
        myJpanel.setRGB(i, j, new Color(c,c,c));
    }
}