public class SpriteAnimation extends JComponent{
    private int currentFrame = 0;
    private BufferedImage[] frames;

    public SpriteAnimation(){
        /**
         * Load your frames
         */
    }

    public void paintComponent(Graphics g){
        currentFrame++;
        if(frame >= 3)
            frame = 0;

        // we pass this as the ImageObserver in case the images are 
        // loaded asynchronously
        g.drawImage(frames[currentFrame], 0, 0, this);                
    }
}