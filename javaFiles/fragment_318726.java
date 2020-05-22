public void actionPerformed (ActionEvent event) {
        Object command = event.getSource();
        if (command.equals(keypadPlus1)) {
            calcLifePoints(event.getActionCommand());
        }
        if (command.equals(keypadMinus1)) {
            calcLifePoints(event.getActionCommand());
        }
        if (command.equals(keypadPlus2)) {
            calcLifePoints(event.getActionCommand());
        }
        if (command.equals(keypadMinus2)) {
            calcLifePoints(event.getActionCommand());
        }

    }