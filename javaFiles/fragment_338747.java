public static void main(String[] args) {
    Map<String, Integer> tVals = new HashMap<>();
    tVals.put("t1", 5);
    tVals.put("t2", 10);
    tVals.put("t3", 30);

    for (int i = 1; i < 4; i++) {
        System.out.println(tVals.get("t" + i));
    }
}