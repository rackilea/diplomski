public class oddNumbers {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        do {
            System.out.println("enter two number");
            int number = kb.nextInt();
            int number2 = kb.nextInt();
            do {
                if (number % 2 != 0) {
                    System.out.println(number);
                }
                number++;
            } while (number < number2);

            System.out.println("You want to continue : (Y/N) ");
        } while("Y".equalsIgnoreCase(kb.next().trim()));

    }
}