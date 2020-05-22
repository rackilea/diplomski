float rotValue = 0;
public void userLogic() {
    if (keyboard.isKeyDown(Keyboard.KEY_A)) {
        rect.setLocation(rect.x - 1, rect.y, rect.width, rect.height);
        rotValue-=.1f;
        rotValue=rotValue<0?rotValue+360:rotValue;
        rect.setRotation(rotValue);
    } else if (keyboard.isKeyDown(Keyboard.KEY_D)) {
        rect.setLocation(rect.x + 1, rect.y, rect.width, rect.height);
        rotValue+=.1f;
        rotValue=rotValue>=360?rotValue-360:rotValue;
        rect.setRotation(rotValue);
    } if (keyboard.isKeyDown(Keyboard.KEY_W)) {
        rect.setLocation(rect.x, rect.y - 1, rect.width, rect.height);
    } else if (keyboard.isKeyDown(Keyboard.KEY_S)) {
        rect.setLocation(rect.x, rect.y + 1, rect.width, rect.height);
    }
}