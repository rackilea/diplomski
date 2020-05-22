public class InnerController {

    private final ReadOnlyStringWrapper text = new ReadOnlyStringWrapper();

    public ReadOnlyStringProperty textProperty() { 
        return text.getReadOnlyProperty() ;
    }

    public String getText() {
        return text.get();
    }

    public void buttonClick(ActionEvent event){
        System.out.println("change label!");
        text.set("Hello world");
    }


    public void initialize() {
   }    
}