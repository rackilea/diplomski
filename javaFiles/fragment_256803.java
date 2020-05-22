public class Jtext {
JTextField[] txt;
    public Jtext() {
        txt = new JTextField[100];
        int i = 0;
        txt[i] = new JTextField();
        Listener l = new Listener();
        txt[i].addActionListener(l);

    }    
    class Listener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            JTextField txt = (JTextField) e.getSource();
            if(txt.equals(YourJtextField){

            }
        }

    }
}