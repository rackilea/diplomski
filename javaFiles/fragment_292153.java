final Scanner scanner = new Scanner(new FileReader(DATADIR + "data.txt"));
        final TreeMap<Integer, List<Integer>> myMap = new TreeMap<Integer, List<Integer>>();
        while (scanner.hasNextLine()) {
            final String[] line = scanner.nextLine().split("\t");
            final Integer key = Integer.parseInt(line[0]);
            final Integer value = Integer.parseInt(line[1]);
            if (myMap.containsKey(key)) {
                myMap.get(key).add(value);
            } else {
                final List<Integer> valueList = new LinkedList<>();
                valueList.add(value);
                myMap.put(key, valueList);
            }
        }