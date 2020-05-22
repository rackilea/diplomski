public void handle(KeyEvent event) {
            TextField field = (TextField) event.getSource();
            String text = field.getText();
            int lastCharIndex = 0;

            if (field.getText().length() > 0) {
                lastCharIndex = field.getText().length() - 1;
            }

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
                if (field.getText().length() == 0 && event.getCharacter().matches("\\s")) {
                    System.out.println("Exit 3");
                    event.consume();
                    return;
                } else if (field.getText().substring(lastCharIndex).equals(" ")
                        && event.getCharacter().matches("\\s")) {
                    System.out.println("Exit 4");
                    event.consume();
                    return;
            }
        }
        Region icon = (Region) ((StackPane)field.getParent()).getChildren().get(1);
        text = text+event.getCharacter();
        System.out.println("Char: " + text);

        return;
}