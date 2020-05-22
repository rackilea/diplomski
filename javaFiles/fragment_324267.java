for (int i = 0; i<10; i++)
            { 
                buttons[i] = new JButton(""+i);
                numPanel.add(buttons[i]);
                buttons[i].addActionListener(this);
            }

            for (int i = 0; i<6; i++)
            {
                OPbuttons[i] = new JButton(operation[i]);
                opPanel.add(OPbuttons[i]);
                OPbuttons[i].addActionListener(this);
            }