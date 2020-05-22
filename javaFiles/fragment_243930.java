public static void main(String[] args) {
        // TODO Auto-generated method stub
        if (args != null && args.length > 0) {
            if (args[0].equals("-h"))
                System.out.print("Hello,");
            else if (args[0].equals("-g"))
                System.out.print("Goodbye,");

            // print the other command-line arguments
            for (int i = 1; i < args.length; i++)
                System.out.print(" " + args[i]);

        } else{
            System.out.print("No Arguments passed");
        }
        System.out.println("!");
    }