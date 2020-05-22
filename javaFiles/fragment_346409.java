jComboBoxReceiver.getEditor().getEditorComponent().addKeyListener(new
    java.awt.event.KeyAdapter() {
        public void keyPressed(java.awt.event.KeyEvent e) {
            if(e.getKeyCode() == KeyEvent.VK_ENTER)             {
                sr = new Search(((String) jComboBoxReceiver.getSelectedItem()));    
                usrList = sr.searchUser();
                DefaultComboBoxModel model = jComboBoxReceiver.getModel();
                model.removeAllElements();
                for(int i=0;i<usrList.size();i++){
                    model.addElement(usrList.get(i).getUserName());
                }
            }
        }         
    };