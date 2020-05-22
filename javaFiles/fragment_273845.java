private boolean isFirstClick = true;

// ...

button.addMouseListener(new MouseAdapter()
{
    public void mouseClicked(MouseEvent e)
    {
        if(isFirstClick)
        {
             System.out.println("You have clicked once");
             isFirstClick = false;
        }
        else
        {
             System.out.println("You have clicked twice");
             isFirstClick = true;
        }
    }
});