TextField textField = new TextField();

        textField.addValidator(

                new StringLengthValidator(
                     "Must be between 2 and 10 characters in length", 2, 10, false));