@Override
public void keyPressed(KeyEvent e) {
    if (e.getKeyCode()==KeyEvent.VK_ENTER){
        System.out.println("Hello");

        JOptionPane.showMessageDialog(null , "You've Submitted the name " + nameInput.getText());
    }

}