private void showAlert(String title, String message) 
{
    Alert alert = new Alert(title);
    alert.setString(message);
    alert.setTimeout(Alert.FOREVER);
    MainMidlet.getDisplay().setCurrent(alert);  // this line has been changed
}