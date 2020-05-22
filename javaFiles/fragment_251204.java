public static void main(String[] args) {
    List<Integer> numbers = new ArrayList<>();
    for(int i = 0; i < 10; i++){
        numbers.add(i);
    }

    Collections.shuffle(numbers);

    String result = "";
    for(int i = 0; i < 4; i++){
        result += numbers.get(i).toString();
    }
    System.out.println(result);
}