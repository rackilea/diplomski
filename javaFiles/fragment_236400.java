public <T extends ObjectName1> List<T> getListOfStuff(List<T> statistics) {
    List<T> resultList = new ArrayList<>(statistics.size());

    if (!statistics.isEmpty()) {
        resultList.add(statistics.get(0));

        int date = Integer.parseInt(resultList.get(0).getDate());
        int hour = Integer.parseInt(resultList.get(0).getHour());
    }

    return resultList;
}