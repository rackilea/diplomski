public class GetRequest {

   public static void main( String[] args ) {
      System.out.println( new GetRequest().get( "" ) );
   }

   public String get( String search ) {

      try {
         URL url = new URL( "https://rest.cgorders.com/api/orders/order?access_token=97484431a4525ed2b294b699a3d2f202&id=15755354" );
         HttpURLConnection conn = (HttpURLConnection) url.openConnection();
         conn.setRequestMethod( "GET" );
         conn.setRequestProperty( "Accept", "application/json" );

         conn.connect();

         BufferedReader br = new BufferedReader( new InputStreamReader(
                 conn.getInputStream(), "UTF-8" ) );

         StringBuilder sb = new StringBuilder( 2048 );
         for( String line; (line = br.readLine()) != null; ) {
            sb.append( line );
         }
         conn.disconnect();

         return sb.toString();

      } catch( IOException ex ) {
         Logger.getLogger( Pixabay.class.getName() ).log( Level.SEVERE, null, ex );
         return ex.toString();
      }

   }
}