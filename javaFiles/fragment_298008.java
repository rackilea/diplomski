for(int i=0; i<5; i++){
    double[] dbl = new double[2];
    for(int j=0; j<2; j++){
        System.out.println(j+i);
        dbl[j] = j+i;
    }
    Design des = new Design(dbl);
    map.put(des, Double.valueOf(i));
}