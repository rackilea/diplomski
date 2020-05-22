private final BufferedImage render = new BufferedImage(screen_width, screen_height, BufferedImage.TYPE_RGB);

public void run(){
    final long start = System.nanoTime();
    renderGraphicsOnto(render.getGraphics());
    final renderTime = System.nanoTime() - start;
    try {
        Thread.sleep(25 - renderTime / 1000000); // convert to milliseconds
    } catch(final Exception ignored){
    }
}