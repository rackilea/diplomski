// your objects and other:
private Player player;
// etc.
private static GlobalDataAccess globalInstance;
public static GlobalDataAccess Global(){
    if(globalInstance == null)
    {
         globalInstance = new GlobalDataAccess();
    }
    return globalInstance;
}