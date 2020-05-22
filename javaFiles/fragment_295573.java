Component[] comps = comboBox.getComponents();
for(Component comp : comps){
    if(comp instanceof CellRendererPane){
        JComboBox co = (JComboBox) ((CellRendererPane)comp).getParent();
        co.getEditor().getEditorComponent().addKeyListener(new KeyAdapter()      {
            @Override
            public void keyPressed(KeyEvent arg0) {
                comboBox.showPopup();
                comboBox.setPopupVisible(true);
            }
        });
    }
}