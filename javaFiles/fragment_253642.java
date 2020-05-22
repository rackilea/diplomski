class StringConversion { 
    private String lowerCaseString = "";   
    public String stringConversion(String somestring) {
        lowerCaseString = somestring.toLowerCase();
        return this.lowerCaseString;
    }
}