while (in.hasNextLine()) {
        String line = in.nextLine();

        // I scan here the line obtained, but also could split the String
        // if desired
        Scanner lineScanner = new Scanner(line);
        String name2 = lineScanner.next();
        String addr2 = lineScanner.next();
        String num2 = lineScanner.next();
        int year2 = lineScanner.nextInt();
        lineScanner.close();

        Customer cust2 = new Customer(name2, addr2, num2, year2);
        lst.add(cust2);
    }