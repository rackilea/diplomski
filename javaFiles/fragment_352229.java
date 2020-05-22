import java.util.Arrays;
public class HelloWorld{

     public static void main(String []args){
        String str="a1:b1, a2:b2, [a3:b3-c3, b4, b5], a4:b6";
        System.out.println(Arrays.toString(str.split(",(?![^\\[]*\\])")));
     }
}