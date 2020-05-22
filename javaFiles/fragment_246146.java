Scanner sc = new Scanner(System.in);
String line = sc.nextLine();
while(line.equals("")) {
    System.out.println("Nothing entered - try again!");
    line = sc.nextLine();
}
com = line.charAt(0);