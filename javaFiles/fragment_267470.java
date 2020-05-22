Map<String, String> m = new HashMap<String, String>();
..

List<String> result = new ArrayList<String>();
    for(String s: m.values()){
        if(s.equals("5")){
            result.add(s);
        }
    }