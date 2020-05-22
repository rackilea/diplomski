@Override
public void keyReleased(KeyEvent e) {
    //Forces the current value to be taken from the AbstractFormatter 
    //and set as the current value:
    try {
        jftf.commitEdit();
    } catch (ParseException e1) {
        //Handle possible parsing error...
    }
    System.out.println(jftf.getValue()); 
}