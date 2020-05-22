public static void main(String[] args) {
    List<Integer> times = new ArrayList<Integer>();
    times.add(1);
    times.add(2);
    times.add(3);

    List<Integer> timesCopy = new ArrayList<Integer>(times);
    timesCopy.remove(0);

    System.out.println(times);
    System.out.println(timesCopy);
}