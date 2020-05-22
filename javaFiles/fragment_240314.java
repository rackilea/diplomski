yourLabelName.addMouseListener(new MouseAdapter()  
{  
    public void mouseClicked(MouseEvent e)  
    {  
       //point to the frame you want it to go to from here
       yourFrame = new JFrame("Next JFrame");
       frame.setVisible(true);

    }  
});