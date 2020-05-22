class FrameDemo{

    private JFrame frame;
    private SheepHandlerThread sheepHandlerThread;
    private Farmer farmer;

    public FrameDemo(){
       initComponents();
    }

    private void initComponents() {
        frame = new JFrame(...);
        /* Pass frame reference to the 
           Farmer and SheepHandlerThread
           class    
            */
      farmer = new Farmer(frame);
      sheepHandlerThread = new SheepHandlerThread(frame);   
    }

}