final JTextField field = new JTextField ();
field.setEditable (false);

JButton button = new JButton(new AbstractAction ("Calculate!") {
    @Override
    public void actionPerformed(ActionEvent e) {
        field.setText ("Calculating...");

        new SwingWorker<String, String> ()
        {
            @Override
            protected String doInBackground() throws Exception {
                Thread.sleep(3000L);

                field.setText ("Calculated!");

                return null;
            }
        }.execute();
    }
});

JFrame frame = new JFrame ();
frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
frame.getContentPane ().setLayout (new BorderLayout());
frame.getContentPane ().add (button, BorderLayout.NORTH);
frame.getContentPane ().add (field, BorderLayout.CENTER);
frame.pack ();
frame.setVisible (true);