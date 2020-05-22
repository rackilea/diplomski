public String getDepartmentStatistics(String departmentName) {
    List<Lector> lectorList = /*...*/
    Map<Degree, Integer> result = new EnumMap<>(Degree.class);

    lectorList.stream()
            .map(Lector::getDegree)
            .forEach(degree -> result.merge(degree, 1, Integer::sum));

    return String.valueOf(new JSONObject()
        .put("Assistants", result.getOrDefault(Degree.ASSISTANT, 0))
        .put("Associate professors", result.getOrDefault(Degree.ASSOCIATE_PROFESSOR, 0))
        .put("Professors", result.getOrDefault(Degree.PROFESSOR, 0)));
}