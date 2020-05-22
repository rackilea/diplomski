final JButton btn = new JButton("Button");
        final JRadioButton rdb1 = new JRadioButton("Value1");
        final ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                if (e.getSource() == btn) {
                    //...
                } else if (e.getSource() == rdb1) {
                    //...        
                }
            }
        };
        btn.addActionListener(listener);
        rdb1.addActionListener(listener);