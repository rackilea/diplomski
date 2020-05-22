List<String> al = new ArrayList<String>();
    File file = new File("example.txt");

    try {
        Scanner scanner = new Scanner(file);

        while (scanner.hasNext())
            al.add(scanner.nextLine())
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } finally {
        scanner.close();
    }