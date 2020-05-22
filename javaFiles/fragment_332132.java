public static void main(String[] args) {
        // TODO Auto-generated method stub

        System.out.println("Please input a number.");
        Scanner keyboard = new Scanner(System.in);
        int x = keyboard.nextInt();
        for(int i =1; i<=x*2; i++) {
            if (i%2!=0) {
                System.out.print(i+", ");
            }
        }
        keyboard.close();
}