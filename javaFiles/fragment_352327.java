@SuppressWarnings("serial")
@Override
public void actionPerformed(ActionEvent e) {
    String command = e.getActionCommand();
    if(command.equals("import")) {
        if(importFileChooser.getSelectedFile() == null) {
            MetalFileChooserUI ui = (MetalFileChooserUI) importFileChooser.getUI();
            for(ActionListener a: ui.getDefaultButton(importFileChooser).getActionListeners()) {
                a.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, null) {
                          //Nothing need go here, the actionPerformed method (with the above arguments) will trigger the respective listener
                  });
            }
        }

        if(importFileChooser.getSelectedFile() != null) {
          JOptionPane.showMessageDialog(frame, "Chosen File Name: " + importFileChooser.getSelectedFile().getName());
        }
        else {
            JOptionPane.showMessageDialog(frame, "You entered file name but getSelectedFile() return null");
        }
    }
    else {
        JOptionPane.showMessageDialog(frame, "You clicked other action");
    }
}