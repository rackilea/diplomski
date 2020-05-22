for (int i = 0; i < num; i++){
    System.out.print("Enter name of customer " + (i+1) + ": \n");
    customer.add(in.next());
    System.out.print("Enter how much customer " + (i+1) + ": \n");
    sales.add(in.nextDouble()); 
}