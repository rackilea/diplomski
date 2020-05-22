FileInputStream fis = new FileInputStream("your_file_here");

    Scanner scanner = new Scanner(fis);
    String firstLine = scanner.nextLine();

    firstLine.trim();
    String[] data = firstLine.split(" ");

    int[] intData = new int[data.length];

    for (int i = 0; i < intData.length; i++) {
        intData[i] = Integer.parseInt(data[i]);
    }