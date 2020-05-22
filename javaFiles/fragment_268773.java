public class Tokenizer{
    public static void main(String[] args){
    String str = "Ravi,Tuti,786";//survival of fittest,journey to get job,update skill,try,get job";
     StringTokenizer stk = new StringTokenizer(str,",");
     System.out.println(stk.countTokens());

     while (stk.hasMoreTokens()) {
        System.out.println(stk.nextToken());
     }

   }
}