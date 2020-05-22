List<String> order = new ArrayList<String>();

public void keyPressed(KeyEvent e){
    int key = e.getKeyCode();
    for(GameObject tempObject : handler.object){
        if(tempObject.getId() == ID.Player){
           if(key == KeyEvent.VK_T) order.add("bird");
           if(key == KeyEvent.VK_U) order.add("ox");
           if(key == KeyEvent.VK_G) order.add("dog");
        }
    }
}