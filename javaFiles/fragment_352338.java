Map<String, List<String>> map = new LinkedHashMap<String, List<String>>();
    Iterator itr=map.keySet().iterator();
    while (itr.hasNext()) {
        String key =  itr.next().toString();
        String value=map.get(key).toString();
        System.out.println(key+"="+value);
    }