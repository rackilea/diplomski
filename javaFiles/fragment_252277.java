public class DateAndTimeField extends LayoutContainer {

public static final String DATE_FORMAT = "MM/dd/yyyy";
public static final String TIME_AND_DATE_FORMAT = "MM/dd/yyyy HH:mm";
public static final String DATE_REGEX = "^\\d{4}/\\d{2}/\\d{2}$";
public static final String TIME_REGEX = "^\\d{2}:\\d{2}$";
private TextField<String> dateText;
private TextField<String> timeTextField;

public DateAndTimeField() {
    TableLayout tableLayout = new TableLayout();
    tableLayout.setColumns(4);
    tableLayout.setCellSpacing(5);
    this.setLayout(tableLayout);

    this.add(new Label("Date: "));
    this.add(getDateTextField());
    final DatePicker datePicker = getDatePicker();
    this.add(getDatePickerButton(datePicker));
    this.add(datePicker);
    this.add(new Label("Time: "));
    this.add(getTimeTextField());
    this.add(timeTextField);
}

private TextField<String> getTimeTextField() {
    if (timeTextField == null) {
        timeTextField = new TextField<String>();
        timeTextField.setEmptyText("HH:mm");
        timeTextField.setEnabled(false);
        timeTextField.setWidth(100);
        timeTextField.setValidator(new Validator() {
            @Override
            public String validate(Field<?> field, String value) {
                return value.matches(TIME_REGEX) ? null : "not a valid value";
            }
        });
    }
    return timeTextField;
}

private DatePicker getDatePicker() {
    final DatePicker datePicker = new DatePicker();
    datePicker.addListener(Events.Select, new Listener<ComponentEvent>() {

        public void handleEvent(ComponentEvent be) {
            String date = DateTimeFormat.getFormat(DATE_FORMAT).format(datePicker.getValue());
            dateText.setValue(date);
            datePicker.hide();
            timeTextField.setEnabled(true);
        }
    });
    datePicker.hide();
    return datePicker;
}

private Button getDatePickerButton(final DatePicker datePicker) {
    Button button = new Button();
    button.addSelectionListener(new SelectionListener<ButtonEvent>() {
        @Override
        public void componentSelected(ButtonEvent buttonEvent) {
            if (datePicker.isVisible()) {
                datePicker.hide();
            } else {
                datePicker.show();
            }
        }
    });
    button.setIcon(GXT.IMAGES.grid_groupBy());
    return button;
}

private TextField<String> getDateTextField() {
    if (dateText == null) {
        dateText = new TextField<String>();
        dateText.setWidth(100);
        dateText.setReadOnly(true);
        dateText.setEmptyText(DATE_FORMAT);
    }
    return dateText;
}

public Date getSelectedDate() {
    if (getDateTextField().getValue().matches(DATE_REGEX)) {
        StringBuilder dateAndTimeText = new StringBuilder(dateText.getValue());
        if (timeTextField.getValue().matches(TIME_REGEX)) {
            dateAndTimeText.append(" ").append(timeTextField.getValue());
        }
        return DateTimeFormat.getFormat(TIME_AND_DATE_FORMAT).parse(dateAndTimeText.toString());
    } else {
        return null;
    }
}

public void reset() {
    getDateTextField().clear();
    getTimeTextField().clear();
    getDatePicker().hide();
    getTimeTextField().setEnabled(false);
}