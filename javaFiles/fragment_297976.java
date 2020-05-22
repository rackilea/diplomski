public static void main(String[] args) {
    Integer[][] roomSel = new Integer[6][2];
    roomSel[0][0] = 700;
    roomSel[0][1] = 1400;
    roomSel[1][0] = 630;
    roomSel[1][1] = 1260;
    roomSel[2][0] = 560;
    roomSel[2][1] = 1120;
    roomSel[3][0] = 490;
    roomSel[3][1] = 980;
    roomSel[4][0] = 1120;
    roomSel[4][1] = 2240;
    roomSel[5][0] = 350;
    roomSel[5][1] = 700;


    Scanner scanner = new Scanner(System.in);

    System.out.println("Please select room type: ");
    int roomType = scanner.nextInt();

    System.out.println("Please enter 0 for 7 days and 1 for 14 days: ");
    int days = scanner.nextInt();

    System.out.println("Price is " + roomSel[roomType][days]);
}