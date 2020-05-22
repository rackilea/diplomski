public class Testf {
   public static void main(String[] args){

        String string="I love you";
        String reverse = new StringBuilder(string).reverse().toString();    

        StringBuilder secondReverse = new StringBuilder();
        for (String eachWord : string.split("\\s+")){
            String reversedWord = new StringBuilder(eachWord).reverse().toString();
            secondReverse.append(reversedWord);
            secondReverse.append(" ");

        }

        System.out.println("Old String:"+string);   //Prints out I love you
        System.out.println("New String : "+reverse);//Prints out the reverse  that is "uoy evol I"
        System.out.println("Reversed word two: " + secondReverse.toString());
    }
}