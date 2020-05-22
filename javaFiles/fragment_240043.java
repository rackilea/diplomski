//There is not really any magic happening here.
//This class is just a wrapper for a List with the type ValidationObject.
public class ValidationErrors {

    public List<ValidationObject> errors = new ArrayList<ValidationObject>();

    public void add(String field, String error){
        errors.add(new ValidationObject(field, error));
    }
}