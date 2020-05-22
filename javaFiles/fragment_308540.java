CvScalar[][] s = new CvScalar[img.height()][img.width()];
for (int i = 0; i < img.height(); i++) {
    for (int j = 0; j < img.width(); j++) {
        s[i][j] = cvGet2D(img, i, j);
    }
}