String error = null;
    // Loop for each digit in password
    for (int x = 0; x < passOne.length(); x++) {
        // Testing for a digit
        if (Character.isDigit(passOne.charAt(x))) {
            // Testing for a letter
            if (Character.isLetter(passOne.charAt(x))) {
                // Testing length 6-10 chars
                if (passOne.length() <= 10 && passOne.length() >= 6) {
                    // comparing two passwords
                    if (passOne.equals(passTwo)) {
                        error = "Contratulations, you have a new password!";
                    }
                    // If passwords don't match
                    else {
                        error = "Passwords do not match, please try again.";
                    }
                }
                // If length is wrong
                else {
                    error = "Password must be between 6 and 10 characters long.";
                }
            }
            // If no letter
            else {

                error = "Password must contain at least one letter.";
            }

        }
        // If no digit
        else {
            error = "Password must contain at least one digit.";
        }

        if(error != null) break;

    }

    if(error != null) {
        JOptionPane.showMessageDialog(null, error);           
    }

}