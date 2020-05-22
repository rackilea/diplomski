public void landmarks(int land_no) {
    ArrayList<List<Double>> L3 = new ArrayList<>();
    for(int i = 0; i < land_no; i++) {
        double a = Math.random() * 100;
        double b = Math.round(a);
        List<Double> L1 = new ArrayList<>(); // <-- HERE
        L1.add(b);
        L1.add(b);
        L3.add(i, L1);
        System.out.println(i);
        System.out.println(L3);
    }
}