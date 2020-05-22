private String displayLocation() {
    //...
    return "https://www.google.co.id/maps/@"+latitude+","+longitude;
}

String message = txtMessage.getText().toString() + displayLocation();
if (phoneNo.length()>0 && message.length()>0)
//...