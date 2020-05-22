public static void main(String[] args) {
    ArrayList<Integer> integerArrayList = new ArrayList<>();
    ArrayList<String> stringArrayList = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
        integerArrayList.add(i);
        stringArrayList.add(String.valueOf(i));
    }
    System.out.println(RamUsageEstimator.sizeOf(integerArrayList));  // 240
    System.out.println(RamUsageEstimator.sizeOf(stringArrayList));  // 560
}