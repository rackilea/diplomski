public static int[] createList() {

    Scanner reader = new Scanner (System.in);

    while (true) {

       System.out.print("Enter array size for between [1-50]: ");
       int listSize = Integer.parseInt(reader.nextLine());

        if (listSize > 50 || listSize < 1) {

            System.out.println("Array size must be between [1-50]");

        } else {

            return new int [listSize];
        }

    }

}