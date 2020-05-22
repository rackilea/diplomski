public void actionPerformed(ActionEvent evt)
{
    if(panel)
    {
        //CardLayout pane = (CardLayout)this.getLayout();
        cc.last(this.getContentPane());
        panel = false;
    }
    else
    {
        //CardLayout pane = (CardLayout)this.getLayout();
        cc.first(this.getContentPane());
        panel = true;
    }
    //repaint(); not necessary either..
}