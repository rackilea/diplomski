next = new JButton("next");
    next.addActionListener(
            new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    int nextIndex = tabs.getSelectedIndex()+1;
                    tabs.setSelectedIndex( (nextIndex < tabs.getTabCount())?nextIndex:0 );                                                 
                }
            });

    previous = new JButton("previous");
    previous.addActionListener(
            new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    int previousIndex = tabs.getSelectedIndex()-1;
                     tabs.setSelectedIndex((previousIndex < 0)?tabs.getTabCount()-1:previousIndex);                         
                }
            });