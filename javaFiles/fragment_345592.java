enum Degree {
    PROFESSOR,
    ASSISTANT,
    ASSOCIATE_PROFESSOR
}

class Lector {
    Degree degree;

    public Degree getDegree() {
        return degree;
    }
}

public String getDepartmentStatistics(String departmentName) {
    List<Lector> lectorList = /*...*/
    Map<Degree, Integer> result = new EnumMap<>(Degree.class);

    lectorList.stream()
            .map(Lector::getDegree)
            .forEach(degree -> {
                Integer currentCount = result.getOrDefault(degree, 0);
                result.put(degree, ++currentCount);
            });

    return String.valueOf(new JSONObject()
            .put("Assistants", result.getOrDefault(Degree.ASSISTANT, 0))
            .put("Associate professors", result.getOrDefault(Degree.ASSOCIATE_PROFESSOR, 0))
            .put("Professors", result.getOrDefault(Degree.PROFESSOR, 0)));
}