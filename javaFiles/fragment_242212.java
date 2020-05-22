public void start(Stage primaryStage) throws Exception{
    setPrimaryStage(primaryStage);
    prStage = primaryStage;
    Parent root = FXMLLoader.load(getClass().getResource("../gui/NewUI2.fxml"));

    primaryStage.initStyle(StageStyle.UNDECORATED);
    primaryStage.setScene(new Scene(root, 1280, 720));
    Main.getPrimaryStage().getScene().getStylesheets().add(getClass().getResource("..//gui/css/main-black.css").toExternalForm());

    primaryStage.show();

    // verify if it is windows
    if(System.getProperty("os.name").indexOf("win") >= 0)
        long lhwnd = com.sun.glass.ui.Window.getWindows().get(0).getNativeWindow();
        Pointer lpVoid = new Pointer(lhwnd);
        WinDef.HWND hwnd = new WinDef.HWND(lpVoid);
        final User32 user32 = User32.INSTANCE;
        int oldStyle = user32.GetWindowLong(hwnd, WinUser.GWL_STYLE);
        int newStyle = oldStyle | 0x00020000;//WS_MINIMIZEBOX
        user32.SetWindowLong(hwnd, WinUser.GWL_STYLE, newStyle);
    }
}