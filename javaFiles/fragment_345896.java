class MyTemplate extends StringTemplate {

    public MyTemplate(String action, Date date, /* etc */ ) { /* set the model state */ }

    public String getTemplateFileLocation() { /* point to the template file */ }

    public String process() { /* process the template and return the string */ }

    public String getAction() { /* return the action as a string */ }

    public String getDate() { /* return the formatted date as a string, i.e. */ 
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        return df.format(date);
    }

    public String getCity() { /* return the city as a string */ }

    public String getState() { /* return the state as a string */ }

    public String getZip() { /* return the zip code as a string */ }

    public String getFirstName() { /* return the first name as a string */ }

    public String getLastName() { /* return the last name as a string */ }
}