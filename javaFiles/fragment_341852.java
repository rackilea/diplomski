Statement stmt = ...;
stmt.execute("some sql statement");
SQLWarning warning = stmt.getWarnings();

while (warning != null) {
    System.out.println(warning.getMessage());
    warning = warning.getNextWarning();
}