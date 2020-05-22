public void setupWindowHandlers(Window window) {
    class CloseWindowListener extends ActionListener {
        public void actionPerformed(ActionEvent event) {
            window.close();
        }
    }
    closeButton.addActionListener( new CloseWindowListener() );
    cancelButton.addActionListener( new CloseWindowListener() );
}