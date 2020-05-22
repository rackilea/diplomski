public class myClass implements EntryPoint, ClickHandler {
    final Button myButton = new Button("text");
        :
        :
    myButton.addClickHandler(this);


    @Override
    void onClick(ClickEvent event) {
            ... stuff ...
    }
}