@Override
public void mouseMoved(MouseEvent e) {

    mPosX = e.getX();
    mPosY = e.getY();

    System.out.println(mPosX + ", " + mPosY);

    for (int i = 0; i<handler.object.size(); i++){
        GameObject tempObject = handler.object.get(i);

        if (tempObject.getId() == ID.Player){
            tempObject.setX(mPosX);
            tempObject.setY(mPosY);
        }
    }
    e.consume();
}