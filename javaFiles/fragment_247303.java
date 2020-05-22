public double calculateFees(String X, String Y){
    int xArrIdx=0;
    for(xArrIdx=0; xArrIdx<XY.length; xArrIdx++){
        if(XY[xArrIdx].equals(X)) break;

    }
    for(yArrIdx=0; yArrIdx<XY.length; yArrIdx++){
        if(XY[yArrIdx].equals(Y)) break;

    }

    return prices[xArrIdx][yArrIdx];
}