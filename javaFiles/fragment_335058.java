/**
 * 
 * @param datePicker
 * @return a java.util.Date
 */
public static java.util.Date getDateFromDatePicker(DatePicker datePicker){
    int day = datePicker.getDayOfMonth();
    int month = datePicker.getMonth();
    int year =  datePicker.getYear();

    Calendar calendar = Calendar.getInstance();
    calendar.set(year, month, day);

    return calendar.getTime();
}