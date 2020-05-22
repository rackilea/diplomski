double factor(int width, int height, int a, int b){
     double factorX = (double) Math.min(a, width - a) / width * 2;
     double factorY = (double) Math.min(b, height - b) / height * 2;

     return Math.min(factorX, factorY);
}