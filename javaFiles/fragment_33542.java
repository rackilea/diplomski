void editorWebViewRequestFocus()
  {
    final WebView view = (WebView) ((GridPane) ((HTMLEditorSkin) editor.getSkin()).getChildren().get( 0 )).getChildren().get( 2 );

    Platform.runLater( () ->
    {
      view.fireEvent( new MouseEvent( MouseEvent.MOUSE_PRESSED, 100, 100, 200, 200, MouseButton.PRIMARY, 1, false, false, false, false,
          false, false, false, false, false, false, null ) );
      editor.requestFocus();
      view.fireEvent( new MouseEvent( MouseEvent.MOUSE_RELEASED, 100, 100, 200, 200, MouseButton.PRIMARY, 1, false, false, false, false,
          false, false, false, false, false, false, null ) );
    } );
  }