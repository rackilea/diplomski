fc.addActionListener(new ActionListener(){
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.equals(JFileChooser.APPROVE_SELECTION)) {
            File selectedFile = fc.getSelectedFile();
            System.out.println(selectedFile.getAbsolutePath());
        }   
    }   
});