btnNext.addActionListener(new ActionListener() {

    // save the iterator, not the list item
    private Iterator<ContactList> iterator;

    public void actionPerformed(ActionEvent arg0) {

        if(iterator == null){
            iterator = list.iterator();
        }

        if(iterator.hasNext())
        {
            ContactList save = iterator.next(); // first time itr is mentioned, assume you mean iterator
            name.setText(save.firstName);
            lastName.setText(save.lastName);
            dob.setText(save.dob);
            homeNum.setText(save.homeNum);
            cellNum.setText(save.cellNum);
        }
     }
 }};