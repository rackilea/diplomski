Map<String, ArrayList<String[]>> map = new TreeMap<>();
    for (String[] strs : attArrayList) {
        if (!map.containsKey(strs[1])) {
            ArrayList<String[]> list = new ArrayList<>();
            list.add(strs);
            map.put(strs[1], list);
        } else {
            map.get(strs[1]).add(strs);
            map.put(strs[1], map.get(strs[1]));
        }
    }
    for (String[] strs : map.get("CompanyA")) {
        System.out.println(Arrays.toString(strs));
    }