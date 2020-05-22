public boolean isValidId(String personalNumber) { 
    // ... code to compute 'sum'
    return sum % 10 == 0;
}

public String validID(String personalNumber) { 
    if (isValidId(personalNumber)) {
        return personalNumber + " is valid";
    } else {
        return personalNumber + " is not valid";
    }
}