frame.addWindowListener(new java.awt.event.WindowAdapter() {
    @Override
    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
        int result = JOptionPane.showConfirmDialog(null, "Sind Sie sicher?", "Schließen", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (result == JOptionPane.YES_OPTION){
            credits.setVisible(true);
            new Timer(2500, new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    System.exit();
                }
            }).start();
        } else {
            //do nothing 
        }
    }
});