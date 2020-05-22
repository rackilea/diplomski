Scanner scan = new Scanner(System.in);
int id = Integer.parseInt(scan.nextLine());

while (id <= 999999 || id >= 10000000) {
    System.out.println("Improper EMPID, please reenter your EMPID.\n");
    id = Integer.parseInt(scan.nextLine());
}