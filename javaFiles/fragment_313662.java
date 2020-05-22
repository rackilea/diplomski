List<Pair<Integer, String>> test = new ArrayList<Pair<Integer, String>>();
test.add(new Pair<Integer, String>(1, "A"));
test.add(new Pair<Integer, String>(2, "B"));
for(Pair<Integer, String> p : test ){
    System.out.println(p.getT());
}