/**
 * Generic action listener that is used for both file selection dialog buttons
 */
private final ActionListener fileSelectionButtonActionListener = new ActionListener()
{
    @Override
    public void actionPerformed(final ActionEvent event)
    {
        final String target = ((JButton) event.getSource()).getName();
        assert (target.equals("file") || target.equals("directory"));

        JFileChooser fileChooser = new JFileChooser(new File(".").getAbsoluteFile());
        fileChooser.setDialogType(JFileChooser.OPEN_DIALOG);
        if(target.equals("directory")) {
            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        }
-->     final int result = fileChooser.showOpenDialog(fileChooser);     <--
        if(result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            if(target.equals("file")) {
                fileTextField.setText(selectedFile.getAbsolutePath());
            } else {
                directoryTextField.setText(selectedFile.getAbsolutePath());
            }
        }
    }
};