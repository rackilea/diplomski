Map<String,List<String>> map = new HashMap<>();
    List<String> list = null;
    for (String elm: str) {
        if (elm.contains("ViewAll")) {
            list = new ArrayList<>();
            map.put(elm, list);
        } else if (list != null) {
            list.add(elm);
        }
    }
    System.out.println(map);