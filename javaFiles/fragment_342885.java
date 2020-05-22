public static void main(String[] args) {

    System.out.println("Input a number(0-9):");
    Scanner sc1 = new Scanner(System.in);
    int inputNo = sc1.nextInt();

    System.out.println("Input number of lines:");
    Scanner sc2 = new Scanner(System.in);

    int inputNoLine = sc2.nextInt();

    for(int line=1 ; line <=inputNoLine; line++) {
        for(int count=0; count<line; count++) {
            System.out.print(inputNo);
        }
        System.out.println();
        inputNo++;
    }
}