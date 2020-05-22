public class MusicPlayerPanel extends JPanel {

private JList list;
private JButton addButton;
private PropertyChangeListener listener = new MyPropertyChangeListener();

//..in some place
addButton.addActionListener(new ActionListener(){
  @Override
  public void actionPerformed(ActionEvent e){
        JFrame form = new FrameForm();
        form.addPropertyChangeListener(FrameForm.BUTTON_CLICKED,listener);
        form.setVisible(true);
  }

});

//in another place

private class MyPropertyChangeListener implements PropertyChangeListener{

    @Override
    public void propertyChange(PropertyChangeEvent evt){
         if(evt == null)
              return;

        if(evt.getPropertyName().equals(FrameForm.BUTTON_CLICKED)){
           String value = (String) evt.getNewValue();
           ((DefaultListModel)list.getModel()).addElement(value); 
        }

    }

}


}