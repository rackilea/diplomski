// You'd have methods in your form to convert fromPicker.getDate() to LocalDate
// and likewise toPicker.
LocalDate fromDate = getFromDate();
LocalDate toDate = getToDate();
if (toDate.isBefore(fromDate)) {
    // Show an error message
}