public class main {
public static void main(String[] args) {
try {
Runtime rt = Runtime.getRuntime() ;
Process p = rt.exec("calc.exe") ;
} catch(Exception exc){
/*handle exception*/
}
    }
}