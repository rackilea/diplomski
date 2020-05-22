public FileDataValidator() {
    // maybe you need some code in here, maybe not
}

public void build(String[] lineData){

    this.lineData = lineData;
    removeLeadingAndTrailingQuotes();

    try
    {
        validateName();
        validateAge();
        validateTown();
    }
    catch(InvalidFormatException e)
    {
        throw new com.myco.myapp.errors.InvalidDataException(e.getMessage());
    }

}