public void actionPerformed(ActionEvent e) {
    String rawBirthday = enterBDayTF.getText();
    try {
        String[] birthday = rawBirthday.split("/");
        int birthMonth = Integer.parseInt(birthday[0]);
        int birthDay = Integer.parseInt(birthday[1]);
        int birthYear = Integer.parseInt(birthday[2]);

        int currentDay = cal.get(Calendar.DAY_OF_MONTH);
        int currentMonth = cal.get(Calendar.MONTH);
        currentMonth++;
        //The current month has to be incremented because in this library
        //they count the months starting from 0. Without incrementing the
        //month, the program works perfectly fine, except for birthday's
        //in the current month, where the age is not calculated properly.

        int currentYear = cal.get(Calendar.YEAR);

        if (currentYear == birthYear)
            userAgeTF.setText("" + 1);
        //this checks to see if the user's birth year is equal to the
        //current year, if it is, it returns one for the user's age
        //since the user's birthday would have already passed.

        if (currentMonth < birthMonth) {
            int age = currentYear - birthYear - 1;
            userAgeTF.setText("" + age);
        }
        if (currentMonth > birthMonth) {
            int age = currentYear - birthYear;
            userAgeTF.setText("" + age);
        }
        if (currentMonth == birthMonth && currentDay < birthDay) {
            int age = currentYear - birthYear - 1;
            userAgeTF.setText("" + age);
        }
        if (currentMonth == birthMonth && currentDay >= birthDay) {
            int age = currentYear - birthYear;
            userAgeTF.setText("" + age);
        }
        //this block of if statements is used to handle if the user's birthday
        //has passed for the current year or not.

    } catch (NumberFormatException x) {
        System.err.println("Invalid Birthday Format: " + x);
        enterBDayTF.setText("");
        userAgeTF.setText("");
        JOptionPane.showMessageDialog(null, "Please enter a birthday in the form MM/DD/YYYY");
    }
}