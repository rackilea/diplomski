import java.util.Scanner;

public class CalculatorCode {
    public static void main(String[] args) {
        while(true){
             Scanner input = new Scanner(System.in);
             String userinput = input.nextLine();
    if(userinput.contains("x")){    
        String[] multiply = userinput.split("x");
        String multiply1 = multiply[0];
        String multiply2 = multiply[1];
        double a = Double.parseDouble(multiply1);
        double b = Double.parseDouble(multiply2);
        double multoutput = a * b;
        System.out.println(a + "x" + b + "=" + multoutput);
            }
    if(userinput.contains("/")){
        String[] divide = userinput.split("/");
        String divide1 = divide[0];
        String divide2 = divide[1];
        double c = Double.parseDouble(divide1);
        double d = Double.parseDouble(divide2);
        double divideoutput = c/d;
        System.out.println(c + "/" + d + "=" + divideoutput);
            }
    if(userinput.contains("-")){
        String[] subtract = userinput.split("\\-");
        String subtract1 = subtract[0];
        String subtract2 = subtract[1];
        double e = Double.parseDouble(subtract1);
        double f = Double.parseDouble(subtract2);
        double suboutput = e - f;
        System.out.println(e + "-" + f + "=" + suboutput);
            }
    if(userinput.contains("+")){
        String[] add = userinput.split("\\+");
        String add1 = add[0];
        String add2 = add[1];
        double g = Double.parseDouble(add1);
        double h = Double.parseDouble(add2);
        double addoutput = g + h;
        System.out.println(g + "+" + h + "=" + addoutput);
            }
        }
    }
}