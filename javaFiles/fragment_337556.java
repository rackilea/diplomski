Account acnt = new Account();
    public void actionPerformed(ActionEvent e)
    {
        Object source = e.getSource();
        if(source == button)
        {

        }

        if(e.getSource() == button)
        {

            if(c.isSelected())
            {

                acnt.setId(accID.getText());
                acnt.setName(accName.getText());
                acnt.setBalance(acnt.getBalance()+Integer.parseInt(amount.getText()));
                //store.add(ad);
                area.append("\nDP-"+ acnt.toString());
                store.add(acnt);
            }

            if(d.isSelected())
            {
                acnt.setId(accID.getText());
                acnt.setName(accName.getText());
                acnt.setBalance(acnt.getBalance()-Integer.parseInt(amount.getText()));
                area.append("\nWD-"+acnt.toString());
                store.add(acnt);
            }


        }       
    }