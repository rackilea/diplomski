File f1 = new File(path);
     StringBuilder f2 = new StringBuilder();
        Scanner scanner = new Scanner(f1).useDelimiter("\\Z");

        while (scanner.hasNext()) {
           f2.append(scanner.next());