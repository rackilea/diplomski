public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int height;
    while (true) {
        System.out.println("What is the height of your window?");
        String cmd = sc.nextLine();
        try {
            height = Integer.parseInt(cmd);
            break;
        } catch (Exception ex) {
            System.out.println("Please enter a number not a word or letter");
        }
    }
    System.out.println("You typed: " + height);
}