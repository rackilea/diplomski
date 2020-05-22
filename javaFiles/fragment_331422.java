String str = "ABCDEF";
    String[] arr = str.split("");
    int sum = 0;

    Map<String, Integer> map = new HashMap<String, Integer>() {
        {
            put("A", 1); put("B", 2); put("C", 3);
            put("D", 4); put("E", 5); put("F", 6);
        }
    };

    System.out.println(Arrays.toString(arr));

    // Iteration starts from index 1, as 1st element is an empty string
    for (int i = 1; i < arr.length; i++) {
        sum += map.get(arr[i]);
    }

    System.out.println("Sum = " + sum);