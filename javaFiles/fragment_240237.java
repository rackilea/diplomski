for(int i = 0; i < items; i++ ) {
    System.out.println("What would you like to purchase?");
    String c = read.nextLine();
    itemArray[i] = c;
    sum += amounts.get(c);
}