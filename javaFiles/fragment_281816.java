JTextField textfield = new JTextField();
        textfield.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField timestep =(JTextField) e.getSource();// you could use this or just your variable.
                String text = timestep.getText();
                AMEC.steptime = Integer.parseInt(text);
            }

        });