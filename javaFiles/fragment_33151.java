public class Editor extends PropertyEditorSupport {

    private final Dao hibernateService;

    public Editor(Dao hibernateService){
        this.hibernateService=hibernateService;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException{
        Author author=hibernateService.getAuthor(Integer.parseInt(text));
        setValue(author);
    }
}