private boolean validGrade(final StringBuilder grade) {
    String gradeString = grade.toString();
    return gradeString.contains("semester") && List.of("2o", "4o", "6o", "8o")
        .stream()
        .anyMatch(gradeString::contains);
}