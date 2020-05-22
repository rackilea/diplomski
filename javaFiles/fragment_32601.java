import java.util.Random;


public class random {
public static void main(String[] args){
String word1=generateWord();

String word2=generateWord();

String word3=generateWord();

System.out.print(word1+"\n"+word2+"\n"+word3+"\n");

String allThreeWithTheFirstLetterCapital=putThemTogether(word1,word2,word3);

System.out.print(allThreeWithTheFirstLetterCapital);
}
   public static String generateWord(){
        Random r=new Random();
        StringBuilder sb=new StringBuilder();
        sb.append((char)(65+r.nextInt(25)));
        for(int i=0;i<9;i++){
        sb.append((char)(97+r.nextInt(25)));
    }
    return sb.toString();

}
public static String putThemTogether(String...strings){
    StringBuilder sb=new StringBuilder(strings[0]);
    for(int i=1;i<strings.length;i++){
        sb.append(strings[i].toLowerCase());
    }
    return sb.toString();}
}