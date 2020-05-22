public SecondaryWindow(Window parent, String title, Modality modality, int width, int height)
{
    // basic setup
    this.stage = new Stage();
    this.root = this.loadRoot();

    this.stage.setScene(new Scene(root, width, heigth));
    this.stage.setMinWidth(this.root.minHeight(-1));
    this.stage.setMinHeight(this.root.minHeight(-1));

    this.stage.initModality(modality);
    this.stage.setTitle(title);
    this.stage.initOwner(window);


    // this will blink your application in the taskbar when unfocused.
    this.stage.focusProperty().addListener(E -> this.stage.toFront());

    // this is quickfix to prevent Alt+ F4 on a secondary screen.
    this.stage.addEventFilter(KeyEvent.KEY_RELEASED, E -> {
            if(E.getCode() == KeyCode.F4 && E.isAltDown())
            {
                E.consume();
                this.ignoreCloseRequest = true;
            }
        });

        this.stage.setOnCloseRequest(E -> {
            if(!this.ignoreCloseRequest)
                this.close();
            E.consume();
            this.ignoreCloseRequest = false;
        });
}