public class MyClass {

    boolean toggle = false;
    /*
      other relative class code
    */


    button.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
        // If button is selected the first time.
        if (e.getSource() == button && !toggle){
            toggle = true;
            /* my output when button is pressed the first time.
            .
            .
            . */

            e.setSource(false);
        }
        // If button is selected the second time.
        if (e.getSource() == button && toggle){
            toggle = false;
            /* my output when button is pressed the second time.
            .
            .
            . */
            e.setSource(false);
        }
    });