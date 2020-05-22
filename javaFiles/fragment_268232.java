public String getMessage() {
    if (detail == null) 
        return super.getMessage();
    else
        return super.getMessage() + 
            "; nested exception is: \n\t" +
            detail.toString();
}