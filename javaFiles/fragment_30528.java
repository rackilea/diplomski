container.setLayout(new GridBagLayout());
    GridBagConstraints c = new GridBagConstraints();
    c.fill=GridBagConstraints.HORIZONTAL;
    for(int i =0 ; i < board.size() ;i++)
    {
        panel =new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints c1 = new GridBagConstraints();
        c1.fill=GridBagConstraints.VERTICAL;
        c1.weighty=-.9;

        //          panel.setBounds(0, 0, 400, 300);
        for(int j=0 ; j< board.get(i).size();  j++)
        {               
            c1.gridx = j;
            c1.gridy = 0;
            c1.insets= new Insets(-5,0,0,-5);
            panel.add(board.get(i).get(j),c1);

        }   
        c.weightx =- 5;
        c.gridx = 0;
        c.gridy =i ;
        c.insets=new Insets(-5,0,-5,0);


        container.add(panel,c);


        //          
    }
    add(container);

    validate();
    repaint();