Alert alert = new Alert(AlertType.INFORMATION);
alert.setContentText("this is a pretty long message that "
                + "should not be truncated in this alert window, no matter "
                + "how long it is");
alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
alert.showAndWait();