@Override
protected void init(VaadinRequest request) {
    HorizontalLayout layout = new HorizontalLayout();
    PopupDateField popupDateField = new PopupDateField();
    NativeSelect hoursSelect = new NativeSelect("Hours");
    for(int i=0; i<24; i++){
        hoursSelect.addItem(i);
    }
    NativeSelect minutesSelect = new NativeSelect("Minutes");
    for(int i=0; i<60; i++){
        minutesSelect.addItem(i);
    }

    class MyValueChangeListener implements ValueChangeListener{
        public void valueChange(ValueChangeEvent event) {
            LocalDate date = popupDateField.getValue().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            int year = date.getYear();
            int month = date.getMonth().getValue();
            int days = date.getDayOfMonth();
            int minutes = minutesSelect.getValue() == null ? 0 : (int) minutesSelect.getValue();
            int hours = hoursSelect.getValue() == null ? 0 : (int) hoursSelect.getValue();
            System.out.println(LocalDateTime.of(year,  month, days, hours, minutes));
        }
    }
    ValueChangeListener listener = new MyValueChangeListener();
    minutesSelect.addValueChangeListener(listener);
    hoursSelect.addValueChangeListener(listener);
    popupDateField.addValueChangeListener(listener);

    setContent(layout);

    layout.addComponent(popupDateField);
    layout.addComponent(hoursSelect);
    layout.addComponent(minutesSelect);
}