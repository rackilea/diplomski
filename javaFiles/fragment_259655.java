public static void main(String args[])


    {
        Scanner scan = new Scanner(System.in);
        int i = scan.nextInt();
        scan.nextLine();
        // double d=scan.nextDouble();
        // Write your code here.

        Double d = 0.0;

        try {

            d = Double.parseDouble(scan.nextLine());

        } catch (NumberFormatException e) {

            e.printStackTrace();

    }

        String s = scan.nextLine();

        System.out.println("String: " + s);
        System.out.println("Double: " + d);
        System.out.println("Int: " + i);
    }