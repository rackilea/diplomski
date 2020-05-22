public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    System.out.println("Please enter an integer greater than 0 and less than 30 or type 'quit' to exit.");

    String input = scan.next();

    if(!input.equals("quit")) {

        int number = Integer.parseInt(input);

        if(number < 0 || number > 30) {
            throw new IllegalArgumentException("number out of range");
        }
        else {
            int i = catalan(number);
            System.out.println(i);
        }

    }

}