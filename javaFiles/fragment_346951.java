final Map<Integer, Pojo> pojoMap = new HashMap<>(pojos.size(), 1f);
    for (final Pojo pojo : pojos) {
        pojoMap.put(pojo.id, pojo);
    }

    final List<Pojo> sortedPojos = new ArrayList<>(ids.size());
    for (final int id : ids) {
        sortedPojos.add(pojoMap.get(id));
    }