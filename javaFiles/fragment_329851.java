final JLabel label=new JLabel("Label");
        // Label must be opaque to display
        // the background
        label.setOpaque(true);

        final Random r=new Random();
        Timer t=new Timer(100,new ActionListener(){
            public void actionPerformed(ActionEvent ae)
            {
                Color c=new Color(r.nextInt(256),r.nextInt(256),r.nextInt(256),r.nextInt(256));
                label.setBackground(c);
            }
        });
        t.start();