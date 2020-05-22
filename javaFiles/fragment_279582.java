public class SO {
 public static void main(String[] args) {
    for(String s : args){ //For each argument
        if(s.indexOf(".") != -1){ //If contains a dot (like a file ext)
            System.out.println(s); //print
        }
    }
 }
}