private String id;
private int age;
private static map indexMap = new HashMap();

public Customer(int a) {
      this.id = a + "C" + index;
      index++;
      this.age = a;
}

public synchronized static int getIndexOfAge(int age) {
    if (!indexMap.contains(age)) {
        indexMap.put(age, 1);
    }
    int theIndex = indexMap.get(age);
    theIndex++;
    indexMap.put(age, theIndex);
}