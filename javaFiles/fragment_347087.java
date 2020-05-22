Scanner in = new Scanner(System.in);
System.out.print("Enter a list of integers: ");

List<Integer> list = new ArrayList<>();
Scanner line = new Scanner(in.nextLine());

// optional
line.useDelimiter("\\D+");

while(line.hasNextInt()) {
    list.add(line.nextInt());
}

System.out.println("You entered " + list);