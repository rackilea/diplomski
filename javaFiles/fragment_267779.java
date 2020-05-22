if (dialog.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
    File selectedFile = dialog.getSelectedFile();

    if (selectedFile.exists()) {
        JOptionPane.showMessageDialog(this, "Please choose another file.");
        return;
    }

    PdfWriter.getInstance(document, new FileOutputStream(selectedFile));
    document.open();
    document.add(new Paragraph(" hello"));
    document.close();
}