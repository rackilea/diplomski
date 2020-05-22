public static void main(String[] args) throws FileNotFoundException{
    File cardNumbers = new File("creditcardnumbers.txt");
    Scanner cardNumbersInput = new Scanner(cardNumbers);

    while(cardNumbersInput.hasNextLine()) {
        String cardNumber = cardNumbersInput.nextLine();
        System.out.println(cardNumber);
    }

    cardNumbersInput.close();
}