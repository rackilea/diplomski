public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        double tmp = getDouble(s, "Tmp");
        double tmp2 = getDouble(s, "Tmp");
        s.close();
    }

    private static double getDouble(Scanner s, String name) {
        double res = 0;
        while (true) {
            System.out.println("Please input " + name + ":");
            if (s.hasNextDouble()) {
                res = s.nextDouble();
                break;
            } else
                s.nextLine();
        }
        return res;
    }