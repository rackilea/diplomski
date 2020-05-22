DatePickerSkin datePickerSkin = new DatePickerSkin(new DatePicker(LocalDate.now()));
Node popupContent = datePickerSkin.getPopupContent();

// force a css layout pass to ensure that lookup calls work
popupContent.applyCss();
popupContent.lookup(".month-year-pane").setVisible(false);

root.setCenter(popupContent);