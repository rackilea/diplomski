public class GetSet 
{
public static String fName[];
@SuppressWarnings("static-access")
public void setFname(String value1, String value2)
{
    fName[] = new String[2];
    fName[1] = value1;
    fName[2] = value2;
}

@SuppressWarnings("static-access")
public String[] getfName()
{
    return this.fName;
}
}