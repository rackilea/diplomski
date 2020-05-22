@Override
public void dialogConfirmed(Person email)
{ 
    GridLayout emailLineLayout = new GridLayout(3, 1);

    // adding components to the GridLayout
    ...

    person.setEmail(email.getEmail());
    emailLayout.addComponent(emailLineLayout);      
}