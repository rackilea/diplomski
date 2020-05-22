Object comp = e.getSource();

if(comp instanceof JButton) {
    // A JButton triggered the event
    JButton pressed =(JButton) comp;

    // Do something with your 'pressed' button
}
else if(comp instanceof JMenuItem) {
    // A JMenuItem triggered the event
    JMenuItem pressedSave = (JMenuItem) comp;

    // Do something with your 'pressedSave' menu item
}