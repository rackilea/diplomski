@Component
private Form yourForm;

@Property
private String inputFromField;

public void onValidate() {
        Pattern p = Pattern.compile("^[a-zA-Z0-9]+$");//Alpha numeric regexp
        Matcher m = p.matcher(inputFromField); 
        if(m.find()) {
          yourForm.recordError(inputFromField,messages.get("This field can only contain letters and numbers"));
        }            
}