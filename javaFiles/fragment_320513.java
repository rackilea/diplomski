int index = 0;
String[] order = new String[10];

public void keyPressed(KeyEvent e){
    int key = e.getKeyCode();
    for(int i=0; i < handler.object.size(); i++){
        GameObject tempObject = handler.object.get(i);
        if(tempObject.getId() == ID.Player){
           if(key == KeyEvent.VK_T) order[index++] = "bird";
           if(key == KeyEvent.VK_U) order[index++] = "ox";
           if(key == KeyEvent.VK_G) order[index++] = "dog";
        }
    }
}