static void disableKeys(InputMap im,String[] keystrokeNames) {              
        for (int i = 0; i < keystrokeNames.length; ++i)
            im.put(KeyStroke.getKeyStroke(keystrokeNames[i]), "none");
    }

disableKeys(textArea.getInputMap(),new String[]{"ENTER"});