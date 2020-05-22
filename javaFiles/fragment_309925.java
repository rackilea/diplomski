public class variables {

public static TinyDB Var=new TinyDB(MainActivity.PublicContext);

public static  int LoadInt(String s){
    return Var.getInt(s);
}
public static void SaveInt(String s, int i){
    Var.putInt(s,i);
}
public static String LoadString(String s){
    return Var.getString(s);
}
public static void SaveString(String s, String sts){
    Var.putString(s,sts);
}

}