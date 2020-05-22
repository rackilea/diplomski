List<Map<Object,Object>> productslist = (List<Map<Object, Object>>) obj.get("products");
    for(Map entry: productslist) {
        for(Object s: entry.keySet()) {
            System.out.println(s.toString());
            System.out.println(entry.get(s).toString());

        }
    }