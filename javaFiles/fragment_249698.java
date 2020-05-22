public class DatePickerControl extends DatePicker {
    private ObjectProperty<Calendar> calendar;

    private DateTimeFormatter dateFormatter = DateTimeFormatter.ISO_DATE ;
    private Format calendarFormatter = DateFormat.getDateInstance();

    public DatePickerControl() {
        super();
        setValue(LocalDate.now());
        calendar = new SimpleObjectProperty<Calendar>(Calendar.getInstance());

        calendar.addListener((obs, oldValue, newValue) -> {
            System.out.println("calendar changed from "+calendarFormatter.format(oldValue.getTime())+" to "+calendarFormatter.format(newValue.getTime()));
            LocalDate localDate = LocalDate.now()
                .withYear(newValue.get(Calendar.YEAR))
                .withMonth(newValue.get(Calendar.MONTH)+1)
                .withDayOfMonth(newValue.get(Calendar.DAY_OF_MONTH));
            setValue(localDate);
        });

        valueProperty().addListener((obs, oldValue, newValue) -> {
            System.out.println("Value changed from "+dateFormatter.format(oldValue)+" to "+dateFormatter.format(newValue));
            Calendar cal = Calendar.getInstance();
            cal.set(getValue().getYear(), getValue().getMonthValue()-1, getValue().getDayOfMonth());
            calendar.set(cal);
        });
    }


    public ObjectProperty<Calendar> calendarProperty() {        
        return calendar;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar.set(calendar);
    }

    public Calendar getCalendar() {
        return calendar.get();
    }
}