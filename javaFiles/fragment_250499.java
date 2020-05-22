this.addWindowListener(new java.awt.event.WindowAdapter() 
{
    @Override
    public void windowClosing(java.awt.event.WindowEvent windowEvent) 
    {
        int ret = JOptionPane.showConfirmDialog(MyJFrame.this, "Are you sure you want to quit?");
        if(ret == JOptionPane.YES_OPTION)
        {
            dispose();
        }
    }
});