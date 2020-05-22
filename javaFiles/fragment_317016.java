if (empty || date == null) {
  setText(null);
  setStyle(""); // can this be null?           
} else {
  LocalDate departureDate = _newDeparture.getValue();
  String text = departureDate.toString();  // or format it for user locale
  setText(text);
  String style = date.isBefore(departureDate) ? "-fx-background-color: red" : "";
  setStyle(style);
}