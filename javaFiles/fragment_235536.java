public class Main {
public static void main(String[] args)
{
    String rule = "F-F+F+F-F-F-F+F+F-F+F-F+F+F-F+F-F+F+F-F-F-F+F+F-FQ";


    int i = 0 ;
    char[] cmds = rule.toCharArray();
    do
    {
        if(cmds[i] == 'F') {
            System.out.println("Foward");
        }
        else if(cmds[i] == '-') {
            System.out.println("Left");
        }
        else if(cmds[i] == '+') {
            System.out.println("Right");
        }
        else // it's surely "Q"
            break ; 
        i++ ;
    }
    while(true);
    System.out.println("Fractal construction terminated.");
    }
}