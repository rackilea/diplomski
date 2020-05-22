public static void RGBToGray2(Mat m){
    ArrayList<Mat> sousMatrices = new ArrayList<Mat>();
    Core.split(m, sousMatrices);
    Mat result = new Mat();
    Core.addWeighted(sousMatrices.get(0), 0.21, sousMatrices.get(1), 0.72, 0, result);
    Core.addWeighted(sousMatrices.get(2), 0.07, result, 1 ,0 , result);
    sousMatrices.set(0,result);
    sousMatrices.set(1,result);
    sousMatrices.set(2,result);
    Core.merge(sousMatrices, m);
}