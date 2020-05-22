String fileName = "PathToFile";
    List<String> strings = new ArrayList<String>();

    //read file to an ArrayList
    try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

        String line;
        while ((line = br.readLine()) != null) {
            strings.add(line);
        }

    } catch (IOException e) {
        e.printStackTrace();
    }

    String code = strings.get(0);
    String key = strings.get(1);

    //cast String key to int[]
    String[] numbers = key.split(" ");
    int[] keyArr = new int[numbers.length];
    for(int i = 0; i < numbers.length; i++) {
        keyArr[i] = Integer.parseInt(numbers[i]);
    }