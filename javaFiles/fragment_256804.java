public class Jtext {
JTextField[] txt;
public static String ACTION_CMD_1 = "txt1";
public static String ACTION_CMD_2 = "txt2";
    public Jtext() {
        txt = new JTextField[5];
        int i = 0;
        txt[i] = new JTextField();
        Listener l = new Listener();
        txt[i].setActionCommand("txt" + counter);

    }    
    class Listener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String actCommand = e.getActionCommand();
            if(actCommand.equals(ACTION_CMD_1)){
                 // code
            }

            if(actCommand.equals(ACTION_CMD_2)){
                 //code
            }
        }

    }