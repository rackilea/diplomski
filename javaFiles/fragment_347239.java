public static void main(String[] args) {
    String[] arrayCentri= {"center1","center2","center3"};
    String[] arrayTocke= {"tocka1","tocka2","tocka3","tocka4","tocka5","tocka6","tocka7","tocka8","tocka9", "tocka10"};
    //concat both arrays to one to get {"center1","center2","center3","tocka1","tocka2" ..."tocka10"}
    String[] centriAndTocke = Stream.concat(Arrays.stream(arrayCentri), Arrays.stream(arrayTocke)).toArray(String[]::new);

    int columns  = arrayCentri.length;        
    String[][] clusterji = IntStream.iterate(0, i -> i + columns)
                                .limit((long) Math.ceil((double) centriAndTocke.length / columns))
                                .mapToObj(j -> Arrays.copyOfRange(centriAndTocke, j, Math.min(centriAndTocke.length, j+columns)))
                                .toArray(String[][]::new);        
    Arrays.stream(clusterji).forEach(row->{System.out.println(Arrays.toString(row));});
}