public String getDepartmentStatistics(String departmentName) {
    List<Lector> lectorList = /*...*/
    Map<Degree, Integer> result =
        lectorList.stream()
            .collect(Collectors.groupingBy(
                 Lector::getDegree,
                 () -> new EnumMap<>(Degree.class),
                 Collectors.counting()
            ));

    return String.valueOf(new JSONObject()
            .put("Assistants", result.getOrDefault(Degree.ASSISTANT, 0))
            .put("Associate professors", result.getOrDefault(Degree.ASSOCIATE_PROFESSOR, 0))
            .put("Professors", result.getOrDefault(Degree.PROFESSOR, 0)));
}