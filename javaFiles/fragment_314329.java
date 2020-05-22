class password
{
    public static void main(String[] args)
    {
        int i;
        String pass,temppass;
        Scanner s=new Scanner(System.in);
        System.out.println("Enter Password: ");
        pass=s.next();
        System.out.println("Re-enter password: ");
        temppass=s.next();
        if(temppass.equals(pass)) // This is how equality must be checked 
        {
                System.out.println("Sucess");
        }
        else
                System.out.println("failed");
    }
}