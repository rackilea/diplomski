public static void main(String[] args){
    List<Integer> numberList = new ArrayList<>();
    numberList.add(1);
    numberList.add(2);
    numberList.add(3);
    numberList.add(4);
    numberList.add(5);
    numberList.add(6);

    List<Integer> evenNumbers = numberList.stream().filter(number -> number % 2 == 0).collect(Collectors.toList());
    System.out.println(evenNumbers);