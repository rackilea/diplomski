public static void main(String[] args) {
    ArrayList<ArrayList<abc>> set1 = new ArrayList<>(); // notice this line
    ArrayList<abc> set2 = new ArrayList<>();
    ArrayList<abc> set3 = new ArrayList<>();

    set1.add(set2);
    set1.add(set3);
    set2.add(new abc("xxxxxx"));
    set2.add(new abc("xxxxx yyyyy"));
    System.out.println(set2.get(0).txt);
    System.out.println(set1.get(0).get(0).txt);
    System.out.println(((abc) set1.get(0).get(0)).txt);
}