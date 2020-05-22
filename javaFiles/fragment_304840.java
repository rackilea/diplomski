double xPoint[][][] = new double[value][fps][64];
double yPoint[][][] = new double[value][fps][64];
for (int counter = 0; counter < value; counter++) {



        for (int i = 0; i < fps; i++) {
            for (int j = 0; j < (44100 / fps); j += ((44100 / fps) / 64)) {

            xPoint[counter][i][j] = magnitude[counter][i][j];