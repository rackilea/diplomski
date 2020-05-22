// Get the converted input values
        Date dateFieldInput = dateField.getConvertedInput();
        Integer hoursInput = hoursField.getConvertedInput();
        Integer minutesInput = minutesField.getConvertedInput();
        AM_PM amOrPmInput = amOrPmChoice.getConvertedInput();

        if (dateFieldInput == null)
        {
            return;
        }