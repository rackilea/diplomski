public class game {

   public static void main(String[] args) { 
     try{
       InputStream is = game.class.getResourceAsStream("/testing.txt");
       BufferedReader reader = new BufferedReader(new InputStreamReader(is));
       System.out.println(reader.readLine());
     } catch( IOException e){
     }
   }
}