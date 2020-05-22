Scanner scanner = new Scanner(new File("C:/text.txt"));
ArrayList<Integer> array1 = new ArrayList<Integer>();

while(scanner.hasNextInt() ){
    array1.add(scanner.nextInt());
}