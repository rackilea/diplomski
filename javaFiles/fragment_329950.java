public static void main(String[] args) {
    String msg = "Hello Bebeb";
    int border=60;
    if(msg.length()%2 ==0){
        border+=1;
    }
    if (msg.length() < 54) {
        for (int x = 0; x <= border; x++) {
            System.out.print("*");
        }
        System.out.print("\n***");

        int length = msg.length();
        int whiteSpace = ((54 - (msg.length())) / 2);


        for (int x = 0; x <= whiteSpace; x++) {
            System.out.print(" ");
        }

        System.out.print(msg);

        for (int x = 0; x <= whiteSpace; x++) {
            System.out.print(" ");
        }
        System.out.print("***");

        for (int x = 0; x <= whiteSpace; x++) {
            System.out.print(" ");
        }

        System.out.print("\n");

        for (int x = 0; x <= border; x++) {
            System.out.print("*");
        }
        System.out.println("");
    }
}