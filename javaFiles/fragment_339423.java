ButtonType foo = new ButtonType("foo", ButtonBar.ButtonData.OK_DONE);
ButtonType bar = new ButtonType("bar", ButtonBar.ButtonData.CANCEL_CLOSE);
Alert alert = new Alert(AlertType.WARNING,
        "The format for dates is year.month.day. "
        + "For example, today is " + todayToString() + ".",
        foo,
        bar);

alert.setTitle("Date format warning");
Optional<ButtonType> result = alert.showAndWait();

if (result.orElse(bar) == foo) {
    formatGotIt = true;
}