JFrame frame = new JFrame();

                JPanel parentPanel = new JPanel();
                parentPanel.setBorder(BorderFactory.createTitledBorder("parent panel"));

                JPanel childPanel = new JPanel();
                childPanel.setBorder(BorderFactory.createTitledBorder("child panel"));
                // Add a button to the child panel
                childPanel.add(new JButton("button"));
                // In the instruction below you have to create and add your ChartPanel
                childPanel.add(yourChartPanel);
                parentPanel.add(childPanel);

                frame.add(parentPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);