Scanner scanner = new Scanner(new FileReader("marks.txt"));

    HashMap<String,Integer> map = new HashMap<String,Integer>();

    while (scanner.hasNextLine()) {
        String[] columns = scanner.nextLine().split("\t");

        map.put(columns[0],Integer.parseInt(columns[1]));
    }

    System.out.println(map);