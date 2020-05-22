private static boolean isAdminWin()
{
    String groups[] = (new com.sun.security.auth.module.NTSystem()).getGroupIDs();
    for (String group : groups) {
      if (group.equals("S-1-5-32-544"))
      return true;
    }
    return false;
}   

public static String getOSName()
{
    return System.getProperty("os.name");
}   


private static boolean isAdminLinux()
{
    return getUserName.equalsIgnoreCase("root"); 
}

public static boolean isAdmin()
{
    if (getOSName().toUpperCase().startsWith("WINDOWS")){
        return isAdminWin();
    } else {
        return isAdminLinux();
    }
}