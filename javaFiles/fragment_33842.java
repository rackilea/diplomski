File file = new File(fileNameReading1);

    Scanner in = null;

    try {
        in = new Scanner(file);
    } catch (FileNotFoundException e) {
        System.out.println("File not found");
        e.printStackTrace();
        return;
    }