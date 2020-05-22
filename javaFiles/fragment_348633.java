private JLabel label;
    private SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

    public TestPane() {
        setLayout(new GridBagLayout());
        label = new JLabel();
        add(label);
        tick();

        Timer timer = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tick();
            }
        });
        timer.start();
    }

    protected void tick() {

        label.setText(sdf.format(new Date()));

    }
}