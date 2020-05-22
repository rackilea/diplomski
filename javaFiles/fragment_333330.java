public FileDataValidator() {
    // maybe you need some code in here, maybe not
}

public void build(Person person, String[] lineData){

    this.lineData = lineData;
    removeLeadingAndTrailingQuotes();
    setNameFromData(person);
    setAgeFromData(person);
    setTownFromData(person);
}

public boolean validate(Person person) {

    try
    {
        validateName(person);
        validateAge(person);
        validateTown(person);
        return true;
    }
    catch(InvalidFormatException e)
    {
        throw new com.myco.myapp.errors.InvalidDataException(e.getMessage());
    }

}