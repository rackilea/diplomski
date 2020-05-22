public boolean userValidate(String username, String password)
{
    if (username.contains(getUsername()) && password.contains(getPassword()))
    {
        System.out.println("User accepted");
        return isvalid = true;
    }else
        System.out.println("Access denied");
    return isvalid = false;
}