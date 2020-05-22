//function that check for existance.
public void boolean checkExist(ArrayList<User> userData, String value, Function<User, String> getter)
{
    boolean found = false;

    for(User u : userData)
    {
        String userValue = getter.apply(user);
        if(value.equals(userValue))
        {
            found=true;
            break;
        }           
        else 
            found=false;            
    }   
    return found;
}