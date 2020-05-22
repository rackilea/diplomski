//replace following in your onCreate method
 for (int i = 0; i < buttonsas.length; i++) {
            Button contextMenuButton = (Button) findViewById(buttonsas[i]);
            contextMenuButton.setText("Action "+i);
            registerForContextMenu(contextMenuButton);
        }