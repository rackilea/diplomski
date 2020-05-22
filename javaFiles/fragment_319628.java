public class AddListFrame extends JFrame{


 private JTextField textfield;
 private JButton submitButton;
 public static final String BUTTON_CLICKED ="buttonClicked";

 // in some place
   submitButton.addActionListener(new ActionListener(){
         @Override
         public void actionPerformed(ActionEvent evt){
               firePropertyChange(BUTTON_CLICKED,null,textfield.getText());
         }

    });
}