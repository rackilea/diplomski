theButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent event) {

            int returnValue = fileChooser.showOpenDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                theFile = fileChooser.getSelectedFile();
                processFile(theFile,gcArrayList,gcStringList,gcDateList);

            }
        }
    });