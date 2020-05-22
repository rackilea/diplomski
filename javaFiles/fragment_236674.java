fc.addPropertyChangeListener(new PropertyChangeListener(){
    @Override
    public void propertyChange(PropertyChangeEvent e) {
        String command = e.getPropertyName();
        if (command.equals(JFileChooser.DIRECTORY_CHANGED_PROPERTY)) {
            File currentDir = fc.getCurrentDirectory();
            System.out.println(currentDir.getAbsolutePath());
        }
    }   
});