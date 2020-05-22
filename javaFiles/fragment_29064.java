public static void main(String[] args) {
    List<Integer> itemPrices = new ArrayList<>();
    try (Scanner input = new Scanner(System.in)) {
        String text;
        while (true) {
            System.out.print("Do you want to enter another value? ");
            text = input.nextLine();
            if (!text.trim().toLowerCase().equals("yes")) {
                break;
            } else {
                System.out.print("Next value: ");
                itemPrices.add(input.nextInt());
            }
        }
    }
}