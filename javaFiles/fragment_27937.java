public void directoryChooser() {
    FileChooser chooser = new FileChooser();
    chooser.setTitle("Choose location To Save Report"):
    File selectedFile = null;
    while(selectedFile== null){
        selectedFile = chooser.showSaveDialog(null);
    }

    File file = new File(selectedFile);
    PrintWriter outFile = null;
    try {
        outFile = new PrintWriter(file);
    } catch (FileNotFoundException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }

    for(int i = 0; i<table.getItems().size(); i++){
        outFile.println(table.getItems().get(i).toString());
    }
    outFile.close();
}