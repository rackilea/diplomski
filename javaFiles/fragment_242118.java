static class MyListener implements ActionListener {
    private File selectedPDF;
    private String selectedPDFName;

    public File getSelectedPDF() {
        return selectedPDF;
    }

    public String getSelectedName() {
        return selectedPDFName;
    }

    public void actionPerformed(ActionEvent arg0) {
        JFileChooser fc = new JFileChooser(System.getProperty("user.home")
                + System.getProperty("file.separator") + "Desktop");
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "Select a PDF Document", "pdf");
        fc.setFileFilter(filter);
        fc.setAcceptAllFileFilterUsed(false);
        int returnVal = fc.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            selectedPDF = fc.getSelectedFile();
            selectedPDFName = selectedPDF.getName();
        } else {
            // Executed when no file selected
        }
    }
}