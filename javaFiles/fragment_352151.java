@Override
public void mouseClicked(MouseEvent e) {
    JLabel clickedPanel = (JLabel) e.getSource();

    //Toggle colours    
    if (clickedPanel.getBackground()==Color.blue)
        clickedPanel.setBackground(Color.red);
    else 
        clickedPanel.setBackground(Color.blue);
}