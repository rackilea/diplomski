public static double[][] generateXY(){
    double[][] result = new double[8][4];
    for(int j = 0; j < 8; j++){

        // generate random value ...

        result[j][0] = value*2;
        result[j][1] = value*3;
        result[j][2] = value*5;
        result[j][3] = value*9;
    }
    return result;
}