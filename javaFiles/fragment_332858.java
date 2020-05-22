public void test() {
    List<Integer> integers = Arrays.asList(1, 4, 1234, 5, 6, 77);
    int secondBiggest = second(integers, -1, 0, 0);
    System.out.println(secondBiggest);
}


public Integer second(List<Integer> a, Integer biggest, Integer secondBiggest, Integer length) {
    if (a.size() > length) {
        Integer cur = a.get(length);
        length++;
        if (cur > biggest) {
            secondBiggest = biggest;
            biggest = cur;
        } else if (cur < biggest && cur > secondBiggest) {
            secondBiggest = cur;
        }
        secondBiggest = second(a, biggest, secondBiggest, length);
    }
    return secondBiggest;
}