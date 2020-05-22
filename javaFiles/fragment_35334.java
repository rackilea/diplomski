public class myClass implements EntryPoint {
    final Button myButton = new Button("text");
        :
        :
    myButton.addClickHandler(new ClickHandler() {
        public void onClick(ClickEvent event) {
            onClickMyButton(event);
        }
    });

    private void onClickMyButton(ClickEvent event) {
            ... stuff ...
    }
}