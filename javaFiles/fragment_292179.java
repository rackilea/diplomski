JRadioButton jrb = new JRadioButton("hello");
    jrb.setEnabled(false);

    jrb.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent me) {
            super.mouseClicked(me);
            JRadioButton jrb = (JRadioButton) me.getSource();
            if (!jrb.isEnabled()) {//the JRadioButton is disabled so we should enable it
                //System.out.println("here");
                jrb.setEnabled(true);
            }
        }
    });