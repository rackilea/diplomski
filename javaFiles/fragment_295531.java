ObjectMapper mapper = new ObjectMapper();
List<LinkedHashMap> listM = mapper.readValue("[{\"abc\":\"abc\"}, {\"asd\":\"asd\"}]", ArrayList.class);
    for (Iterator iterator = listM.iterator(); iterator.hasNext();) {
        LinkedHashMap linkedMap = (LinkedHashMap) iterator.next();
        System.out.println(linkedMap);
    }