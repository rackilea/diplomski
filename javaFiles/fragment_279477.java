Map<String, Integer> fruits = new HashMap<>();

    fruits.put("APPLE", 1);

    fruits.put("BANANA", 2);

    fruits.put("STRAWBERRY", 3);

    fruits.forEach((x,y)->System.out.println(x + " - " + y));