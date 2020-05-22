while (true) {

        System.out.print("Enter a number in the file: ");
        String ln = s.nextLine();
        if("q".equals(ln)) {
            break;//exiting as user entered "q"
        }
        int numb  = Integer.parseInt(ln);
        int i = Arrays.binarySearch(numbers, numb);
        if (i < 0) {
            System.out.print("Number is not in file\n");
        } else {
            System.out.print("Number is in file\n");

        }

    }