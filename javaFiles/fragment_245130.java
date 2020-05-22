public Change( String input) {
    String[] values = input.split(",");
    this.value = values[0];
    this.amount = values[1];
    this.column = values[2];
}