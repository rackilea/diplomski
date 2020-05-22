import datamuse.*;
class Test{
    public static void main(String[] args) {

         DatamuseQuery dQuery = new DatamuseQuery();

         String s = dQuery.findSimilarEndsWith("personal", "g");

         System.out.println(s+"\n\n");
         System.out.println(dQuery.findSimilarStartsWith("personal", "t"));
    }
}