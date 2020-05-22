public boolean onPrepareOptionsMenu(Menu menu)
{
    MenuItem register = menu.findItem(R.id.menuregistrar);      
    if(userRegistered) 
    {           
        register.setVisible(false);
    }
    else
    {
        register.setVisible(true);
    }
    return true;
}