public static void main(string..args) {
String s1= "Slno:0 ahdhajdhjahdjahjdhahd <>";

    String[] sSplit = s1.split("\\s");
    String f[]= sSplit[0].split(":");
   ;
    if(f[0].equals("Slno") && checkInt(f[1])) {
        System.out.println(sSplit[1]);
    }



}
public static boolean checkInt(String i) {
    try {
    Integer.parseInt(i);
    return true;
    }
    catch(Exception ex){
        return false;
    }
}