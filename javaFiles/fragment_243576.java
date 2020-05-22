Query query = entityManager.createNativeQuery(preparedQuery,Tuple.class);
    List<Tuple> resultList = query.getResultList();
    List<Product> resultDto = new ArrayList<>();
    for (Tuple tuple : resultList) {
        HashMap<String, Object> data = new HashMap<>();
        for (String tag : tags) {
            data.put(tag, tuple.get(tag));
        }
        resultDto.add(mapper.map(data, Product.class));
    }
    return resultDto;