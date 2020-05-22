public static void main(String[] args) { // TODO Auto-generated method stub
    System.out.println("Chose 1 or 2 = ");
    Scanner scan = new Scanner(System.in);
    byte a = scan.nextByte();
    if (a==1) 
        HW();
    else if (a==2) {
        System.out.print("Calculation program ... !\nInput Number 1st number = ");
        int x = scan.nextInt();
        System.out.println("");
        System.out.print("Input Operand +,-,*,/ = ");
        char z = scan.next().charAt(0);
        System.out.println("");
        System.out.print("Input 2nd number = ");
        int y = scan.nextInt();
        calc(x,y,z);
    }
    else 
        System.out.println("Please input number 1 or 2 ");
}