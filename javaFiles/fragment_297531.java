@Override
public void start(Stage primaryStage) {
    ColorPicker picker = new ColorPicker();
    StackPane root = new StackPane(picker);
    Scene scene = new Scene(root, 500, 400);

    primaryStage.setScene(scene);
    primaryStage.show();
    picker.showingProperty().addListener((obs,b,b1)->{
        if(b1){
            PopupWindow popupWindow = getPopupWindow();
            Node popup = popupWindow.getScene().getRoot().getChildrenUnmodifiable().get(0);
            popup.lookupAll(".color-rect").stream()
                .forEach(rect->{
                    Color c = (Color)((Rectangle)rect).getFill();
                    // Replace with your custom color  
                    ((Rectangle)rect).setFill(c.brighter());
                });
        }
    });
}

private PopupWindow getPopupWindow() {
    @SuppressWarnings("deprecation") 
    final Iterator<Window> windows = Window.impl_getWindows();
    while (windows.hasNext()) {
        final Window window = windows.next();
        if (window instanceof PopupWindow) {
            return (PopupWindow)window;
        }
    }
    return null;
}