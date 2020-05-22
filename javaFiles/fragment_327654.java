if (ev.getActionCommand().equals("Save2")) {
    //Check if the drawing has already been saved, if not open the dialog
    if(this.savedFile == null) {
        fileChooser2.setDialogType(JFileChooser.SAVE_DIALOG);
        fileChooser2.setDialogTitle("Save as XML savedFile format");

        int res = this.fileChooser2.showSaveDialog(this);
        if (res == JFileChooser.APPROVE_OPTION) {
            final File selectedFile = fileChooser2.getSelectedFile();
            //Store the selected file in the member variable
            this.savedFile = selectedFile;
            this.net.saveToFile(selectedFile.getPath() + ".xml");
        }
    }else {
        //Use the previously selected file and don't show the dialog
        this.net.saveToFile(this.savedFile.getPath() + ".xml");
    }
}