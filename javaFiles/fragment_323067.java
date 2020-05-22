CalendarPicker<PersianCalendar> picker = picker.persianWithSystemDefaults();

picker.setLengthOfAnimations(Duration.seconds(0.7));
picker.setShowInfoLabel(true);
picker.setLocale(new Locale("fa", "IR"));
picker.setShowWeeks(true);

picker.setCellCustomizer(
  (cell, column, row, model, date) -> {
    if (CellCustomizer.isWeekend(column, model)) {
      cell.setStyle("-fx-background-color: #FFE0E0;");
      cell.setDisable(true);
    }
  }
);