// this should be in a while(true) loop
    if (newPhoneNumber.equals(phoneNumber)) {
        sendSms(phoneNumber);
        String code = JOptionPane.showInputDialog("Enter your code");
        boolean result = validateAuthorizationCode(code); // here you validate the code
       if (result) {
           JOptionPane.showMessageDialog(null, "Logged in!" );
       } else {
           JOptionPane.showMessageDialog(null, "Wrong code!" );
       }
    } else {
        noticeWrongNumber(newPhoneNumber); // tell him the number is wrong, please reinput.
    }