puts.foreachRDD(r -> {
        List<String> l = r.flatMap(t -> {
                    Collection<List<Cell>> collection = t._2().getFamilyCellMap().values();
            return collection.stream()
                    .flatMap(Collection::stream)
                    .map(CellUtil::cloneValue))
                    .collect(Collectors.toList());
                }).collect();

        //Mapping for testing
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> map1 = objectMapper.readValue(l.get(1), new TypeReference<Map<String, Object>>(){});
        Map<String, Object> map2 = objectMapper.readValue(l.get(2), new TypeReference<Map<String, Object>>(){});

        System.out.println(map1);
        Assert.assertEquals(map1.get("attribute1").toString(), expected1);
        //etc
        System.out.println(map2);
        Assert.assertEquals(map2.get("attribute2").toString(), expected2);
        //etc
    }
    return null;
});