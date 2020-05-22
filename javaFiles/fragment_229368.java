public static void main(String[] args) throws Exception {
    int numberArray = 0;
    int[] list = new int[16];

    File numbers = new File("numbers.txt");
    int i =0;

// Check for arrayIndexOutofBound Exception. SInce size is defined as 16

    try (Scanner getText = new Scanner(numbers)) {
        while (getText.hasNext()) {
            numberArray = getText.nextInt();
            list[i] = numberArray;
             i++;
        }
        getText.close();
    }
    System.out.println(numberArray);
    int sum = 0;
    for (int i = 0; i < list.length; i++) {
        sum = sum + list[i];
    }
    System.out.println(list);
}
}