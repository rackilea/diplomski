public class Button extends JPanel
{
    private Graphics page;
    public Button(Graphics aPage)
    {

        page = aPage;
        JButton change;
        Font font1 = new Font("sansserif", Font.PLAIN, 10);


        setBackground(Color.black);
        change = new JButton("Change Light");
        change.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent event) 
            {
                page.setColor(Color.green);
                page.fillOval(20, 220, 60, 60);