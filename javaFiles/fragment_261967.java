private Scanner x;
private String user_name, password;
public void openFile()
{
    try
    {
        x = new Scanner(new File("FILE PATH"));
    }
    catch(Exception e)
    {System.out.println("Couldn't find file"); System.exit(0);}
}

public boolean checklog(String username, String password)
{
    String temp;
    String[] info;

    while(x.hasNext())
    {
        temp = x.nextLine();
        info = temp.split(" ");

        //info[0] = id, info[1] = username, info[2] = password, info[3] = age;
        //Right here that means the username and password is correct
        if(info[1].equals(username) && info[2].equals(password))
        {
            System.out.println("Login Successful");
            return true;
        }
    }
    System.out.println("Login failed wrong id or password");
    return false;
}