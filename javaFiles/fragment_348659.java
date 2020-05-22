try (
            final Scanner scanner = new Scanner(newBufferedReader(txt, utf8));
            final PrintWriter pw = new PrintWriter(newBufferedWriter(csv, utf8, StandardOpenOption.CREATE_NEW))) {
        while (scanner.hasNextLine()) {
            pw.println(scanner.nextLine().replace('|', ','));
        }
    }