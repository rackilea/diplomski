public class Outer
    extends JFrame
{
    private final JButton buttonA;
    private final JButton buttonB;

    {
        buttonA = new JButton("A");
        buttonB = new JButton("B");
    }

    // do not put these in the constructor unless the Outer class is final
    public void init()
    {
        buttonA.addActionListener(new AListener());
        buttonB.addActionListener(new BListener());
    }

    private void aMethod()
    {
    }

    private void bMethod()
    {
    }

    public void AListener
        implements ActionListener
    {
        public void actionPerformed(final ActionEvent evt)
        {
            aMethod();
        }
    }

    public void BListener
        implements ActionListener
    {
        public void actionPerformed(final ActionEvent evt)
        {
            bMethod();
        }
    }
}