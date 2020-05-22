private class DeleteButtonListener implements ActionListener {
     @Override
     public void actionPerformed(ActionEvent e) {
        for(Component component : namePanel.getComponents()) {
           if(component instanceof JCheckBox) {
              if(((JCheckBox)component).isSelected())
                 namePanel.remove(component);
           }
        }
        namePanel.revalidate();
        namePanel.repaint();
     }   
}