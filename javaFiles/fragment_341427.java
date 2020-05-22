boolean firstFrame = true;

@Override
public void paintComponent(Graphics g){
    super.paintComponent(g);
    if(firstFrame){
        t.start();
        firstFrame = false;
    }
    //rest of render code...
}