@Override
public void actionPerformed(final ActionEvent e) 
{
    if(((JButton)e.getSource()).getName().equals("start"))
    {
        for(final Component c : QuizShow.frame.getContentPane().getComponents())
        {
            if(c.getName().equals("wrapper"))
            {
                ((JPanel) c).removeAll();
                c.repaint();
                QuizPanel qp = new MainQuizPanel();
                ((JPanel) c).add(qp);
                qp.setup();
                c.validate();

                break;
            }
        }
    }           
}