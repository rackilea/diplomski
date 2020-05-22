Scanner input = new Scanner("1 apple, 3 bananas, 2 pears");
input.useDelimiter(",?\\s");
while(input.hasNext()){
    int numItems = input.nextInt();
    System.out.println(numItems);
    String item = input.next();
    System.out.println(item);
    System.out.println("----");
}