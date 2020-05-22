public class ButtonHandler implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent event) {
        JButton b = (JButton)event.getSource();
        b.setBackground(Color.RED);
    }

     //Button Code if I click one button it goes here. I have set ID's via     ActionCommand
}