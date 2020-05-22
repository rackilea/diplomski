/**
 * Overlay a dialog on top of the WebView.
 *
 * @param dialogNode the dialog to overlay on top of the view.
 */
private void overlayView(Node dialogNode) {
    // if the view is already overlaid we will just ignore this overlay call silently . . . todo probably not the best thing to do, but ok for now.
    if (!(webView.getParent() instanceof BorderPane)) return;

    // record the view's parent.
    BorderPane viewParent = (BorderPane) webView.getParent();

    // create an overlayPane layering the popup on top of the webview
    StackPane overlayPane = new StackPane();
    overlayPane.getChildren().addAll(webView, new Group(dialogNode));
    webView.setDisable(true);

    // overlay the popup on the webview.
    viewParent.setCenter(overlayPane);
}

/**
 * Removes an existing dialog overlaying a WebView.
 */
private void removeViewOverlay() {
    BorderPane viewParent = (BorderPane) webView.getParent().getParent();
    viewParent.setCenter(webView);
}

public EventHandler<WebEvent<String>> createAlertHandler() {
    return stringWebEvent -> {
        AlertHandler alertHandler = new AlertHandler(
                stringWebEvent.getData(),
                event -> {
                    webView.setDisable(false);
                    removeViewOverlay();
                }
        );
        overlayView(alertHandler);

        // todo block until the user accepts the alert.
    };
}

. . .

// add an effect for disabling and enabling the view.
getView().disabledProperty().addListener(new ChangeListener<Boolean>() {
    final BoxBlur soften = new BoxBlur();
    final ColorAdjust dim = new ColorAdjust();
    {
        dim.setInput(soften);
        dim.setBrightness(-0.5);
    }

    @Override
    public void changed(ObservableValue<? extends Boolean> observableValue, Boolean oldValue, Boolean newValue) {
        if (newValue) {
            getView().setEffect(dim);
        } else {
            getView().setEffect(null);
        }
    }
});

. . . 

public class AlertHandler extends VBox {
    public AlertHandler(String message, EventHandler<ActionEvent> confirmHandler) {
        super(14);

        // add controls to the popup.
        final Label promptMessage = new Label(message);
        final ImageView alertImage = new ImageView(ResourceUtil.getImage("alert_48.png"));
        alertImage.setFitHeight(32);
        alertImage.setPreserveRatio(true);
        promptMessage.setGraphic(alertImage);
        promptMessage.setWrapText(true);
        promptMessage.setPrefWidth(350);

        // action button text setup.
        HBox buttonBar = new HBox(20);
        final Button confirmButton = new Button(getString("dialog.continue"));
        confirmButton.setDefaultButton(true);

        buttonBar.getChildren().addAll(confirmButton);

        // layout the popup.
        setPadding(new Insets(10));
        getStyleClass().add("alert-dialog");
        getChildren().addAll(promptMessage, buttonBar);

        final DropShadow dropShadow = new DropShadow();
        setEffect(dropShadow);

        // confirm and close the popup.
        confirmButton.setOnAction(confirmHandler);
    }
}

. . . 

getView().getEngine().setOnAlert(dialogFactory.createAlertHandler());