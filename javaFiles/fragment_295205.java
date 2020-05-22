editor = new EditorEngine();
IHMObserver ihm = new IHMObserver(editor);

// commands creation comes here

ihm.setCommands(commands);
editor.registerObserver(ihm);