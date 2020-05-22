private boolean validGrade(final StringBuilder grade) {
    String gradeString = grade.toString();
    return List.of("2o", "4o", "6o", "8o")
        .stream()
        .map(x -> x + " semester")
        .collect(Collectors.toSet())
        .contains(gradeString);
}