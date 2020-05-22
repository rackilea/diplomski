public String ageDescription(short age){
    if (age < 2){
        return "less than 2";
    }

    if (age <= 3){
        // we know age >= 2 since we didn't return
        return "more than 2 but less than or equal to 3";
    }
    // no comparison for last value
    return "You're older than 3";
}