try (Scanner sc = new Scanner(new File("test.txt"), "UTF-8")) {
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
        }
        // note that Scanner suppresses exceptions
        if (sc.ioException() != null) {
            throw sc.ioException();
        }
    }