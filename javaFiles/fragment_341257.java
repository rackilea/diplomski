private Person(final String firstName, final String lastName) {
    if(StringUtils.isBlank(firstName)) {
        throw new IllegalArgumentException("First name can't be blank/empty/null"); 
    }
    if(StringUtils.isBlank(lastName)) {
        throw new IllegalArgumentException("Last name can't be blank/empty/null"); 
    }
    this.firstName = firstName;
    this.lastName = lastName;
}