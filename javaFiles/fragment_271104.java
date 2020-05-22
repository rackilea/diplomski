public void onHomePhoneChangeListener(ChangeEvent event) {
    String phone = "223-32-23";
    try {
        validatePhoneNumber(phone);
        //more code maybe update the database
    } catch(PhoneNotValidException pe) {
        JOptionPane.showMessageDialog(null,"Please enter a valid phone number");
    } catch(Exception ex) {
        System.err.println("Other error different that Phone not valid");
    } 
}