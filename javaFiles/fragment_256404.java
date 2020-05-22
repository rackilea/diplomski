public static void main(String arg[]) {
        ArrayList<Integer> arrList = null;
        Scanner scan = null;
        char choice = 'n';
        try {
            arrList = new ArrayList<Integer>(10);
            scan = new Scanner(System.in);
            do {
                System.out.println("Enter 10 element and add in ArrayList");
                for (int i = 0; i < 10; i++) {
                    System.out.print("Enter element [" +i+"] :: ");
                    int number = scan.nextInt();
                    arrList.add(number);
                }

                for (Integer number : arrList) {
                    System.out.println("Elements in list = " + number);
                }
                int retval = arrList.size();
                if (retval == 10) {
                    arrList.clear();
                }
                System.out.println("Performing clear operation !!");
                System.out.println("Do you want to continue !!");
                String next = scan.next();
                choice = next.charAt(0);
            } while ((choice == 'y') || (choice == 'Y'));
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            scan.close();
            System.out.println("Exit  !!");
        }
    }