if (field.getText().length() >= max_Lengh) {
            System.out.println("Exit 1");
            event.consume();
            return;
        }

        if (fullTrimming) {
            if (event.getCharacter().matches("\\s")) {
                System.out.println("Exit 2");
                event.consume();
                return;
            }
        } else {
            ...
        }
        ...