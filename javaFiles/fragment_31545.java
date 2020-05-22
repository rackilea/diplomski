{
    // ... Initialization of the JPanel ...
    int constantSum=10;
    soldexep_spin.addChangeListener(new MyListener(soldexep_spin, durexep_spin, constantSum));
    durexep_spin.addChangeListener(new MyListener(durexep_spin, soldexep_spin, constantSum));
}

private class MyListener implements javax.swing.event.ChangeListener
{
    private final JSpinner base;

    private final JSpinner image;

    private final int constantSum;

    public MyListener(JSpinner base, JSpinner image, int constantSum)
    {
        super();
        this.base=base;
        this.image=image;
        this.constantSum=constantSum;
        // Initializes the image value in a coherent state:
        updateImage();
    }

    public void stateChanged(ChangeEvent e)
    {
        updateImage();
    }

    private void updateImage()
    {
        int baseValue=((Number)this.base.getValue()).intValue();
        int imageValue=((Number)this.image.getValue()).intValue();
        int newImageValue=this.constantSum - baseValue;
        if (imageValue != newImageValue)
        {
            // Avoid an infinite loop of changes if the image value was already correct.
            this.image.setValue(newImageValue);
        }
    }