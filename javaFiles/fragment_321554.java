public class BoundDatePickerCellEditor extends DatePickerCellEditor {

    public BoundDatePickerCellEditor() {
        super();
    }

    public BoundDatePickerCellEditor(DateFormat dateFormat) {
        super(dateFormat);
    }

    public void setLowerBound(Date date) {
        datePicker.getMonthView().setLowerBound(date);          
    }

    public void setUpperBound(Date date) {
        datePicker.getMonthView().setLowerBound(date);          
    }

}