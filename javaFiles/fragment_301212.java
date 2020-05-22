for (int x = -width/2; x <= width/2; x++) {
    for (int y = -height/2; y <= height/2; y++) {
        eulerNumberProductExponent = (Math.pow(x,2) + Math.pow(y,2)) / (2 * Math.pow(sigma,2));
        eulerNumberProduct = Math.pow(Math.E, -1*eulerNumberProductExponent);
        coefficient = piProduct * eulerNumberProduct;
//            gaussianTemplate[y][x] = coefficient;
        System.out.println("At x: "+x+" and y: "+y+" the coefficient is: "+coefficient);
    }
}