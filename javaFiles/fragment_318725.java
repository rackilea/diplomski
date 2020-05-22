public void actionPerformed (ActionEvent event) {
        String command = event.getActionCommand();
        if (command.equals("+")) {
            calcLifePoints(command);
        }
        if (command.equals("-")) {
            calcLifePoints(command);
        }
        if (command.equals(" + ")) {
            calcLifePoints(command);
        }
        if (command.equals(" - ")) {
            calcLifePoints(command);
        }

    }