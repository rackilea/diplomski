class Menu {
    public static String getInput(String prompt) {
        String user;
        Scanner scan = new Scanner(System.in);
        System.out.println(prompt);
        return user = scan.nextLine();
    }
}