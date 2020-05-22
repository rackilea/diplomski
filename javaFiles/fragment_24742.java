private void listeners() {

    button1.setOnAction(e->{
        doAction();
    });

    keyboardShortcut.setOnAction(e->{
        doAction();
    });

}

void doAction() {
    System.out.println("Some Action");
}