public class RegexExamples {
public static void main(String[] args)
{
    String str="+$109,852.65";
    String numbers;
     numbers=str.replaceAll("[^0-9.]", "");
    System.out.println("Numbers are: " + numbers);
}}