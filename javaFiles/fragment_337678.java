List<WebElement> columns1 = this.columns.stream()
        .filter(e -> !e.getText().equals("Instructor"))
        .collect(Collectors.toList());

List<WebElement> columns2 = new ArrayList<>();
columns.forEach(column -> {
    if (!column.getText().equals("Instructor"))
        columns2.add(column);
});