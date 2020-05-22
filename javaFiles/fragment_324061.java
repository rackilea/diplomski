public String validID(String personalNumber) { 
    // ... code to compute 'sum'
    if (sum % 10 == 0) {
        return personalNumber + " is valid";
    } else {
        return personalNumber + " is not valid";
    }
}