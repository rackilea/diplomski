public void landmarks(int land_no) {
    ArrayList<List<Double>> L3 = new ArrayList<>();
    for(int i = 0; i < land_no; i++) {
        double a = Math.random() * 100;
        double b = Math.round(a);
        L3.add(i, Arrays.asList(b, b)); // <-- HERE
        System.out.println(i);
        System.out.println(L3);
    }
}