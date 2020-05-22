public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num1 = getInt(in);
        int num2 = getInt(in);
        System.out.println(num1 + " " + num2);
    }

    public static int getInt(Scanner in) {
        System.out.print("Enter number: ");
        while (true) {
            String line = in.nextLine();
            try {
                int num = Integer.parseInt(line);
                return num;
            } catch (NumberFormatException ex) {
                System.out.print("Enter correct input!!\nEnter nubmer: ");
            }
        }
    }