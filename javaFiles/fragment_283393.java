public class JRadioButtonTest {

public static void main(String[] args) {
    JFrame f = new JFrame();
    final ButtonGroup btns = new ButtonGroup();
    final JRadioButton btn1 = new JRadioButton("Button 1");
    final JRadioButton btn2 = new JRadioButton("Button 2");
    btns.add(btn1);
    btns.add(btn2);
    EventAdapter ea = new EventAdapter(btns);
    btn1.addActionListener(ea);
    btn2.addActionListener(ea);
    btn1.addItemListener(ea);
    btn2.addItemListener(ea);

    f.setLayout(new FlowLayout());
    f.add(btn1);
    f.add(btn2);
    f.pack();
    f.setLocationRelativeTo(null);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setVisible(true);
}

public static class EventAdapter implements ActionListener, ItemListener
{
    private ButtonGroup bg;

    boolean itemStateChanged = false;

    public EventAdapter(ButtonGroup bg)
    {

        this.bg = bg;
    }


    @Override
    public void itemStateChanged(ItemEvent itemEvent) {
        itemStateChanged = true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
            if (!itemStateChanged)
            {
                System.out.println("UnSelected");
                bg.clearSelection();
            }
        itemStateChanged = false;
    }

}

}