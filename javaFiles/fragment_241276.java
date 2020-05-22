static boolean validEmail(String email) {
    // editing to make requirements listed
    // return email.matches("[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}");
    return email.matches("[A-Z0-9._%+-][A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{3}");
}

void checkEmails() {
    for(String email : emailAddresses) {
        if(validEmail(email)) {
             // it's a good email - do something good with it
        }
        else {
             // it's a bad email - do something... bad to it? sounds dirty...
        }
    }
}