public class AllowedAccess
{
    private SecureClass secure;
    public setSecureClass( SecureClass secure )
    {
        this.secure = secure;
    }

    ...
}

public class SecureClass
{
     private SecureClass() {}

     public static void Create( AllowedAccess allowed )
     {
          allowed.setSecureClass( new SecureClass() );
     }

     ...
}