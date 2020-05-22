public static void main(String[] args) {
    String[] arrayCentri= {"center1","center2","center3"};
    String[] arrayTocke= {"tocka1","tocka2","tocka3","tocka4","tocka5","tocka6","tocka7","tocka8","tocka9", "tocka10"};

    int rows     = arrayTocke.length/arrayCentri.length + (arrayTocke.length%arrayCentri.length == 0 ? 1 : 2);
    int columns  = arrayCentri.length;
    int rowCount = 0;

    String[][] clusterji  = new String[rows][columns];
    clusterji[rowCount++] = arrayCentri;
    for(int i=0;i < arrayTocke.length; i += columns){
        clusterji[rowCount++] = Arrays.copyOfRange(arrayTocke, i, Math.min(arrayTocke.length,i+columns));
    } 
    Arrays.stream(clusterji).forEach(row->{System.out.println(Arrays.toString(row));});
}