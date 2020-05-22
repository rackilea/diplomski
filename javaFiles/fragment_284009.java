class Main {
    public static void main(String[] args) {
        String input = new Scanner(System.in).nextLine();
        if(input.contains("===="))
            System.out.println("Contains ====");
        else
            System.out.println("Doesn't contain ====");
    }
}