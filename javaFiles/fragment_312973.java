public class UserInterfacePanel extends JPanel {
    private JToggleButton startButton;
    private JToggleButton stopButton;
    private int top = 3, left = 3, bottom = 3, right = 3;
    private Insets i = new Insets(top, left, bottom, right);

    public UserInterfacePanel()  {
        setup();
    }

    private void setup()  {
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        setupButtons();
        setupButtonsActions();

        c.insets = i;
        c.weightx=0.5; //c.weightx=0.0;
        c.weighty=0.5; //c.weighty=0.5;

        c.gridx=0;
        c.gridy=0;
        add(startButton, c);

        c.gridx=1;
        c.gridy=0;
        add(stopButton, c);

        JButton b1 = new JButton("+1");
        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                i = new Insets(top+1, left+1, bottom+1, right+1);
                c.insets = i;
                repaint();
            }
        });
        add(b1, BorderLayout.SOUTH); 

        //...
    }