SimpleDateFormat dateFormat;
//check if the string to parse contains a dot
if (stringContainingTimestamp.contains(".")) {
    dateFormat = new SimpleDateFormat("MM.dd.yyyy HH:mm");
} else {
    dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm");
}
//rest of the code...