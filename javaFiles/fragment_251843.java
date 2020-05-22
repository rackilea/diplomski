JButton jbt_ok = new JButton("OK");
    JButton jbt_skip = new JButton("Skip");
    JButton jbt_cancel = new JButton("Cancel");

    boolean greyOutSkipButton = true;

    jbt_ok.addMouseListener(new MouseAdapter() {

        @Override
        public void mouseClicked(MouseEvent e) {
            System.out.println("OK was clicked");

        }
    });

    jbt_cancel.addMouseListener(new MouseAdapter() {

        @Override
        public void mouseClicked(MouseEvent e) {
            System.out.println("Cancel was clicked");

        }
    });

    if(greyOutSkipButton)
        jbt_skip.setEnabled(false);
    else

        jbt_skip.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Skip was clicked");

            }
        });

    Object[] options = {jbt_ok, jbt_skip, jbt_cancel};

    JOptionPane.showOptionDialog(null, "Click OK to continue", "Warning",
            JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
            null, options, options[0]);