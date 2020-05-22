private void addContactJButtonActionPerformed( ActionEvent event )
{   
    Contact newContact = new Contact();

    contactArrayList.add( newContact );

    position = contactArrayList.size() - 1;

}