public static void main(String Args[]) {
        String shypo, scat1, scat2;
        Scanner console = null;
        try {
            console = new Scanner(System.in);
            // input of each side
            System.out.print("hypotenuse = ");
            shypo = console.next();

            System.out.print("cathetus 1 = ");
            scat1 = console.next();

            System.out.print("cathetus 2 = ");
            scat2 = console.next();

            if ("x".equalsIgnoreCase(shypo)) {
                System.out.println("Hypotenuse = " + hypoC(Double.parseDouble(scat1), Double.parseDouble(scat2)));
            } else if ("x".equalsIgnoreCase(scat1)) {
                System.out.println("cathetus 1 = " + Cat1C(Double.parseDouble(shypo), Double.parseDouble(scat2)));
            } else if ("x".equalsIgnoreCase(scat2)) {
                System.out.println("cathetus 2 = " + Cat2C(Double.parseDouble(shypo), Double.parseDouble(scat1)));
            } else {
                System.err.println("ERROR");
            }
        } finally {
            if (console != null)
                console.close();
        }
    }