public static int getInput() {
        while (!sc.hasNextInt())
        {
            sc.nextLine();
            System.out.print("Please enter integer only. Try again: ");
        }
        int result = sc.nextInt();
        sc.nextLine();
        return result;
    }