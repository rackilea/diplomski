public Panel1(){
            xTwin.setEditable(false);
            xCousin.setEditable(false);
            xSexy.setEditable(false);

            xTwin.setBorder(new LineBorder(Color.red));
            xCousin.setBorder(new LineBorder(Color.green));
            xSexy.setBorder(new LineBorder(Color.blue));

            this.setLayout(new BorderLayout());
            JPanel panel = new JPanel(new GridLayout(1, 3));
            JPanel buttonPane = new JPanel(new FlowLayout());
            buttonPane.add(cancel);
            this.add(buttonPane,BorderLayout.NORTH);
            this.add(panel,BorderLayout.CENTER);



            JPanel p1 = new JPanel();
            JPanel p2 = new JPanel();
            JPanel p3 = new JPanel();

            p1.setLayout(new BorderLayout());
            p2.setLayout(new BorderLayout());
            p3.setLayout(new BorderLayout());

            JPanel twinPanel = new JPanel(new FlowLayout()); 
            twinPanel.add(cnstT);
            twinPanel.add(getT);
            p1.add(twinPanel, BorderLayout.NORTH);
            p1.add(xTwin, BorderLayout.CENTER);
            p1.add(msgTwin, BorderLayout.SOUTH);

            JPanel cousinPanel = new JPanel(new FlowLayout()); 


            cousinPanel.add(cnstC);
            cousinPanel.add(getC);
            p2.add(cousinPanel, BorderLayout.NORTH);
            p2.add(xCousin, BorderLayout.CENTER);
            p2.add(msgCousin, BorderLayout.SOUTH);


            JPanel sexyPanel = new JPanel(new FlowLayout()); 
            sexyPanel.add(cnstS);
            sexyPanel.add(getS);
            p3.add(sexyPanel, BorderLayout.NORTH);
            p3.add(xSexy, BorderLayout.CENTER);
            p3.add(msgSexy, BorderLayout.SOUTH);
            panel.add(p1);
            panel.add(p2);
            panel.add(p3);
        }