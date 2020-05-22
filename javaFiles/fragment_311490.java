public void parseDate(String string){
        try{
            Date date = Date.parse(string);
        }catch(IllegalFieldValueException e){
            System.err.println("Date " + string + "is invalid in your local");
        }
    }