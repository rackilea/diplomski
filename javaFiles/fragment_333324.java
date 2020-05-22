private boolean isValid = false;

public FileDataValidator(String[] lineData){

    this.lineData = lineData;
    removeLeadingAndTrailingQuotes();

    try
    {
        validateName();
        validateAge();
        validateTown();
        isValid = true;
    }
    catch(InvalidFormatException e)
    {
        isValid = false;
    }
}

public boolean isValid() {
    return isValid;
}