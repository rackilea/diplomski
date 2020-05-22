private boolean iconifyStateChanged;

// ...

wndMinMax = new WindowAdapter(){

    public void windowIconified(WindowEvent e){
        if(debug)debug("Window Iconfied!!");
        iconifyStateChanged = true;
    }
    public void windowDeiconified(WindowEvent e){
        if(debug)debug("Window DeIconfied!!");
        iconifyStateChanged = true;
    }
};
this.addWindowListener(wndMinMax); 

addComponentListener(new ComponentAdapter()                     
{                                                               
    public void componentResized(ComponentEvent e) //V.43
    {
        if (e.getSource() instanceof JFrame) //V.43
        {
            // This will run after any pending WindowEvents.
            EventQueue.invokeLater(() -> {
                if (!iconifyStateChanged)
                {
                    updateUiChanged(e.getComponent().getWidth(),
                                    e.getComponent().getHeight()));
                }
                iconifyStateChanged = false;
            });
        }
    }                                                           
});