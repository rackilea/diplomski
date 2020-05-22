public void setName(final String name) throws MyCustomException {
    Pattern r = Pattern.compile("[a-zA-Z]+");
    Matcher m = r.matcher(line);
    if(!m.find())
        throw new MyCustomException("Name Not Valid");

    this.id = ++EmployeeInfo1.next_id;
    this.name = name;
}