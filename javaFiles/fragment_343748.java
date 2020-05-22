public class DrawTest {
    public static void main(String[] args){
        JFrame frame = new JFrame("SSCCE");
        frame.setLayout(new BorderLayout());
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       

        final DrawComp d = new DrawComp();
        final JScrollBar hbar,vbar;
        hbar = new JScrollBar(JScrollBar.HORIZONTAL, 0, 1, 0, 500);
        vbar = new JScrollBar(JScrollBar.VERTICAL, 0, 1, 0, 500);

        frame.setLayout(null);
        frame.add(d);      
        frame.add(hbar);      
        frame.add(vbar);      
        d.setBounds(0, 0, 300, 300);
        vbar.setBounds(460, 0, 20, 480);
        frame.setVisible(true);

        vbar.addAdjustmentListener(new AdjustmentListener() 
        {
            public void adjustmentValueChanged(AdjustmentEvent e) 
            {
                d.setLocation(d.getX(), -vbar.getValue());
            }
        });
    }
}