private boolean confirmFirstName(String firstName) {
    System.out.println("You wrote "
            + firstName
            + " is that correct? \n"
            + "Y or N");
    final String answer = sc.next().toUpperCase();
    return answer.equalsIgnoreCase("y");
}

private String enterFirstName() {
    System.out.println("Please enter Client's first name");
    final String sFirstName = sc.nextLine().toUpperCase();
    return sFirstName;
}

private void getFirstNameV1() {
    final int maxTrials = 5;
    // loop for max trials times and break if input is correct
    for (int i = 0; i < maxTrials; i++) {
        final String firstName = enterFirstName();
        if (confirmFirstName(firstName)) {
            setMonthlyRates(firstName);
            break;
        }
    }
}

private void getFirstNameV2() {
    final String firstName = enterFirstName();
    final boolean valid = confirmFirstName(firstName);
    // use a recursive function but take care,
    // there is no exit instead of entering a valid value otherwise you are in an infinite loop
    if (valid) {
        setMonthlyRates(firstName);
    } else {
        getFirstNameV2();
    }
}

private void getFirstNameV3() {
    // first time input
    String firstName = enterFirstName();
    boolean valid = confirmFirstName(firstName);
    // if not valid loop until its valid, there is also no exit of this loop
    while (!valid) {
        firstName = enterFirstName();
        valid = confirmFirstName(firstName);
    }
    setMonthlyRates(firstName);
}

private void getFirstNameV4() {
    // first time input
    String firstName = enterFirstName();
    boolean valid = confirmFirstName(firstName);
    final int maxTrials = 5;
    // if not valid loop for max trials times
    for (int i = 0; i < maxTrials || valid; i++) {
        firstName = enterFirstName();
        valid = confirmFirstName(firstName);
    }
    if (valid) {
        setMonthlyRates(firstName);
    }
}

private void setMonthlyRates(String firstName) {
    monthlyRates.setFirstName(firstName);
}