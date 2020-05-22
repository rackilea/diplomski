public class ConfirmDialog implements ActionListener {
    JFrame main;
    ConfirmCallback callback;

    public ConfirmDialog(String msg,String[] opts, ConfirmCallback lc) {
        this(msg,"Selection",opts,lc);
    }

    public ConfirmDialog(String msg,String title ,String[] opts,  ConfirmCallback lc) {
        main = new JFrame();
        main.setTitle(title);
        this.callback = lc;
        main.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        GridBagConstraints gbc = new GridBagConstraints();
        GridBagLayout layout = new GridBagLayout();

        JPanel panel = new JPanel();
        panel.setLayout(layout);
        panel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0; gbc.gridy =0;
        gbc.gridwidth = opts.length; gbc.gridheight = 1;
        gbc.insets = new Insets(3,3,3,3);

        JLabel mainLabel = new JLabel(msg);

        layout.setConstraints(mainLabel, gbc);
        panel.add(mainLabel);

        gbc.gridy = 1;
        gbc.gridwidth= 1;

        int cnt = 0;
        for (String s: opts) {
            JButton submitButton = new JButton(s);
            submitButton.setActionCommand(Integer.toString(cnt++));
            submitButton.addActionListener(this);   
            gbc.gridx = cnt;
            layout.setConstraints(submitButton, gbc);
            panel.add(submitButton);
        }
        main.add(panel);
        main.pack();
        main.setLocationRelativeTo(null);
        main.setVisible(true);

    }

    public ConfirmDialog() {}

    @Override
    public void actionPerformed(ActionEvent e) {
        callback.run(Integer.decode(e.getActionCommand()));
        main.dispose();
    }

    public void Test() {
        ConfirmCallback cb = new ConfirmCallback(){
            @Override
            public void run(int arg) {
                JOptionPane.showMessageDialog(null, "The user just entered: "+arg);
            }
        };
        new ConfirmDialog("Please choose",new String[] {"a","b","c"},cb);
    }

    public static void main(String args[]) {
        new ConfirmDialog().Test();
    }
}