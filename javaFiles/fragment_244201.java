@Component
public class ContentQueryValidator implements Validator{
    @Override
    public boolean supports(Class<?> aClass) {
        return ContentQuery.class.equals(aClass);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        ContentQuery query = (ContentQuery) obj;

        List<Integer> contentTemplate = query.getContentTemplate();
        List<Integer> displayTemplate = query.getDisplayTemplate();

        if(contentTemplate == null && displayTemplate == null){
            errors.reject("No query provided");
        }
        // More validation here..
    }
}