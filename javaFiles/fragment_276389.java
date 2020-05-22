Platform.runLater(() ->
{
    Hyperlink detailsButton = ( Hyperlink ) alert.getDialogPane().lookup( ".details-button" );

    alert.getDialogPane().expandedProperty().addListener(
            ( ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue ) ->
    {
        detailsButton.setText( newValue ? "My less text" : "My more text" );
    });

    // trigger listeners
    alert.getDialogPane().setExpanded( true );
    alert.getDialogPane().setExpanded( false );
});