private static void createAndShowGUI() {
    ...
    blue.addActionListener( new Action() );
    red.addActionListener( new Action() );
    ...
}

public class Action implements ActionListener {
    @Override
    public void actionPerformed( ActionEvent e ) {
        MyPanel d = new MyPanel();
    }
}