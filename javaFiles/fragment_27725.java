public static void main (String [] args ) {
        System.out.println("Give me a three digit integer and I will print out each individual digit");
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();
        String str = Integer.toString(number);
        for(int i=0; i<str.length(); i++){
            System.out.println(str.charAt(i));
        }
    }