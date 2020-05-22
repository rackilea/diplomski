@Parsed
    @Validate(nullable = false)
    public void setSomeString(String value){
        if(value.length() < 3 || value.length() > 5){
            throw new DataValidationException("SomeString can't have length " + value.length());
        }
        this.someString = value;
    }