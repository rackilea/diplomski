public void confirmation(TextField username, PasswordField password) throws NameException
{
data.loadDatabase();
for(int i = 0; i < data.LoginMembers.size(); i++)
{
    if(username.getText().equals(data.LoginMembers.get(i).getUsername()))
    {
            this.a = true;
            System.out.println("Username right");

            if(password.getText().equals(data.LoginMembers.get(i).getPassword()))
            {
                this.b = true;
                System.out.println("Password right");
                this.user = data.LoginMembers.get(i).getClass().getSimpleName().toString();
                break;
            }
            else
            {
                System.out.println("Password wrong");
                this.a = false;
                throw new NameException();
            }
    } 

    else
    {
            System.out.println("Username wrong");
            this.a = false;
            throw new NameException();
    }


}