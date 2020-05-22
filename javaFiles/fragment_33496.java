final Button btOk = (Button) dlg.getDialogPane().lookupButton(ButtonType.OK);
btOk.addEventFilter(
    ActionEvent.ACTION, 
    event -> {
        // Check whether some conditions are fulfilled
        if (!validateAndStore()) {
            // The conditions are not fulfilled so we consume the event
            // to prevent the dialog to close
            event.consume();
        }
    }
);