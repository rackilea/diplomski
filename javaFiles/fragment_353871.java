private Uri ussdToCallableUri(String ussd) {

    String uriString = "";

    if(!ussd.startsWith("tel:"))
        uriString += "tel:";

    for(char c : ussd.toCharArray()) {

        if(c == '#')
            uriString += Uri.encode("#");
        else
            uriString += c;
    }

    return Uri.parse(uriString);
}