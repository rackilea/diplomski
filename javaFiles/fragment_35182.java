public class TestInput {

    public static double[] inputmethod() {
        double list[] = new double[10];
        Scanner in = new Scanner(System.in);
        double number;
        System.out.println("please enter a double : ");

        for (int i = 0; i < list.length; i++) {
            while (!in.hasNextDouble()) {
                in.next();
                System.out.println("Wrong input, Please enter a double! ");
            }
            list[i] = in.nextDouble();
            System.out.println("you entered a double, Enter another double: ");

        }
        return list;
    }

    public static void main(String args[]) {
        inputmethod();
    }

}