Map<String, List<Integer>> map = new LinkedHashMap<>();
        // Map<String, List<Integer>> map = new HashMap<>();
        List<Integer> li = new ArrayList<>();
        li.add(1);
        li.add(2); 
        li.add(3);
        // MathUtils.sum()
        map.put("a", li);
        // map.put("a", 5);

        List<Integer> li2 = new ArrayList<>();
        li2.add(3);
        li2.add(-1); 
        li2.add(1);
        map.put("b", li2);


        List<Integer> li3 = new ArrayList<>();
        li3.add(10);
        li3.add(-1); 
        li3.add(9);
        map.put("c", li3);

        map = sortByValues(map);

        for (Map.Entry<String, List<Integer>> entry: map.entrySet()) {
            System.out.println(entry.getKey() + "," + entry.getValue());
        }