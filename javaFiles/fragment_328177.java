public static double[][] readMatrixFrom(String file) throws FileNotFoundException {
    Scanner input = new Scanner(new FileReader(file));
    List<List<Double>> al = new ArrayList<>();
    while (input.hasNextLine()) {
        String line = input.nextLine();
        List<Double> ll = new ArrayList<>();
        Scanner sc = new Scanner(line);
        while (sc.hasNextDouble()) {
            ll.add(sc.nextDouble());
        }
        al.add(ll);
    }
    double[][] d = new double[al.size()][];
    for (int i = 0; i < al.size(); i++) {
        List<Double> list = al.get(i);
        d[i] = new double[list.size()];
        for (int j = 0; j < d[i].length; j++) {
            d[i][j] = list.get(j);
        }
    }
    return d;
}