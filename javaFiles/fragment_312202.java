@Override
public void actionPerformed(ActionEvent e) {
    if(horizontalMovement==HorizontalMovement.NONE ||
                 movement==HorizontalMovement.NONE){
        horizontalMovement = movement;
    }else{
        horizontalMovement = HorizontalMovement.NONE;
    }
}