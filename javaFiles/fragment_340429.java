HashMap<Integer, List<Integer>> testData = new HashMap<>();
    testData.put(1, new ArrayList<>(Arrays.asList(777)));

    HashMap<Integer, List<Integer>> testData = new HashMap<>();
    testData.put(1, Arrays.asList(777));

    HashMap<Integer, List<Integer>> testData2 = new HashMap<>();
    for (Map.Entry<Integer, List<Integer>> entry : testData.entrySet()) {
        testData2.put(entry.getKey(), new ArrayList<>(entry.getValue()));
    }
    testData2.get(1).add(888);
    System.out.println(testData);
    System.out.println(testData2);