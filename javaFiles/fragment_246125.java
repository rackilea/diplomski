b.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                DatePicker dp = new DatePicker(f);
                Point bP = b.getLocationOnScreen();
                dp.d.setLocation(bP.x, bP.y + b.getHeight()); 
                dp.d.setVisible(true);
                text.setText(dp.setPickedDate());
            }
        });