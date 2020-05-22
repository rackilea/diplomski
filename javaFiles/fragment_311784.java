public class MisterySoda {
public static void main(String[] args) {
    String soda = "soda";
    String pop = "pop";
    String coke = "coke";
    String pepsi = "pepsi";
    String say = pop;

    carbonated(soda, pop, pepsi);        // say pepsi not soda or coke
    carbonated(coke, soda, pop);         // 
    carbonated(pop, pepsi, pepsi);       // 
    carbonated("pop", pop, "koolaid");   // 
    carbonated(say, "say", pop);         // 
}
public static void carbonated(String str1, String str2, String str3) {
     System.out.println("say " + str1 + " not " + str2 + " or " + str3);
} }