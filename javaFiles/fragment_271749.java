Scanner scanner = null;

    try {
        scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            System.out.println(scanner.next());
            //do whatever you need here
        }
    } finally {
        if (scanner != null) {
            scanner.close();
        }
    }