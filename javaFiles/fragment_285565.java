List<Map<String, String>> items =
    file.getFileInfo()
        .getSemiFileInfos()
        .stream() 
        .map(m-> {
            Map<String, String> itemMap = new HashMap<String, String>();
            itemMap.put("item", m.getItem()); 
            itemMap.put("item2", m.getItem2().split(":",1)); // this doesn't produce a String
                                                             // value so perhaps you are
                                                             // missing some additional logic
                                                             // that would  extract one 
                                                             // String from the String[]
            return itemMap;
        })
        .collect(Collectors.toList());