DateTimeFormatter dateFormatter
                = DateTimeFormatter.ofPattern("MMM dd, yyyy", Locale.ITALY);
    //Checks to see if New Due Date is a date set before today's date

    //Grabs today's date
    LocalDate today = LocalDate.now();

    //Grabs reactivateDateChooser1, converts it into LocalDate (if not null)
    Date reactivateUtilDate = reactivateDateChooser1.getDate();

    //If the date chooser is empty, then error message will show
    if (reactivateUtilDate == null) {
        JOptionPane.showMessageDialog(null, "Please select a date", 
                    "Needs Date", JOptionPane.ERROR_MESSAGE);
    } else {
        LocalDate reactivateDate = reactivateUtilDate.toInstant()
                    .atZone(ZoneId.of("Asia/Singapore"))
                    .toLocalDate();

        //If the new Due Date is before or on today's date, then error message will show
        //Otherwise, if the new date is after today's date, then the function will happen
        if (reactivateDate.isAfter(today)) {
            changeStatusToActive();
            statusCheck1.setText("");
            refreshClassTable();
            closeReactivateDialog();
        } else {
            String todayString = today.format(dateFormatter);
            JOptionPane.showMessageDialog(null, 
                        "Please select a date after " + todayString,
                        "Select Valid Date", JOptionPane.ERROR_MESSAGE);
        }
    }