@Override
public void actionPerformed( ActionEvent e ) {
    if ( e.getSource() == button1 ) {
        present = something;
        button1.setVisible(false);
        //something();
        visiblePanel();
        previous = something;
    }

}