private Integer[] getThreeRandomNumber() {
    HashSet<Integer> integers = new HashSet<>(3);
    Random random = new Random();
    while (integers.size() < 3) {
   // add number generation logic below
integers.add(Integer.parseInt(just_numbers[random.nextInt(just_numbers.length)]));
    }
    return integers.toArray(new Integer[3]);
}