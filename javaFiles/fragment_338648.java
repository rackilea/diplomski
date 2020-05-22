public class GUI extends JFrame { 

    public void addActionListenerToButton(ActionListener listener) {
        button.addActionListener(listener);
    }

    ....

}

public class Game { 

    private GUI gui;  

    public Game () {
        this.gui = new GUI ();
        this.gui.addActionListenerToButton (new ActionListener () {
            public void actionPerformed (ActionEvent evt) {
                play ();                       
            }
        });  
    }

    ...
}