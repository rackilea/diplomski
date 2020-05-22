void sendEmail(Person person) {
    if(person == null) {
        throw new IllegalArgumentException("person cannot be null");
    }
    if(!person.hasEmail()) {
        throw new IllegalArgumentException("person must have an email address");
    }


    // code to send email here
}