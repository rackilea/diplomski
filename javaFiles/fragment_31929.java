public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int pageSize = 4096;
    int address = 0;
    if (address < 2) {
        System.out.println("Enter the address: ");
        address = in.nextInt();
    }
    int pageNumber = address / pageSize;
    int offset = address % pageSize;
    System.out.println("The address " + address + " contains: Page number = " + pageNumber + " And off set = " + offset);
}