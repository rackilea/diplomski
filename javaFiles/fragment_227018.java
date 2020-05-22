public class ... {
     private Timer wipeOutTimer;

     public ...() {
          wipeOutTimer = new Timer(5000, new ActionListener() {
              public void actionPerformed(ActionEvent event) 
              {
                  statusLabel.setText("");
              }
          });
          wipeOutTimer.setRepeats(false);
    }