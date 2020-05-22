String[] names = {"a","b","a","a","c","b"};
    Integer[] numbers = {5,2,3,1,2,1};

    Map<String, Integer> totals = new HashMap<String, Integer>(); 

    for (int i = 0; i < names.length; i++) {
        if (totals.containsKey(names[i])) {
            totals.put(names[i], totals.get(names[i]) + numbers[i]);
        } else {
            totals.put(names[i], numbers[i]);
        }
    }

    System.out.println(totals);