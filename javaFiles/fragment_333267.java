System.out.println("Write the income of each month.");
ArrayList<Integer> array = new ArrayList<>();
while(true){
    months++;
    System.out.println("Write the income for month" + months + ":");
    int income = input.nextInt();
    if(income >= 0){
        sum += income;

        array.add(income);

    }
    else {
        break;
    }
}