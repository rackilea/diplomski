public class EditWorkflow<O, E extends Editor<O>> {

    SimpleBeanEditorDriver<O, E> driver; 

    private E editor;

    void edit(O p) {
        driver.initialize(editor);
        driver.edit(p);
    }

    void save() {
        O edited = driver.flush();
        //doSomethingWithEditedObject(edited);
    }

    public void initialize(E editor, SimpleBeanEditorDriver<O, E> driver) {
        this.editor = editor;
        this.driver = driver;
    }

}