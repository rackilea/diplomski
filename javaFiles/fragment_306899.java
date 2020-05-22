import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import com.google.gson.Gson;

public class Test_Application
{
   public static void main(
      String[] args ) throws Exception
   {
      Gson gson = new Gson();
      String json = readUrl(
         "http://api.wunderground.com/api/57dd9039b81a9c21/" +
         "conditions/q/CA/San_Francisco.json" );
      System.out.println( json );

      Map< String, Object > decoded =
         gson.fromJson(
            json,
            new TypeToken< Map< String, Object>>() {}.getType());
      System.out.println( decoded );

      Answer answer = gson.fromJson( json, Answer.class );
      System.out.println( answer.response.version );
      System.out.println( answer.response.termsofService );
      System.out.println( answer.response.features.get( "conditions" ));
      System.out.println( answer.current_observation.image );
      System.out.println( answer.current_observation.display_location );
   }

   static class Response
   {
      String                version;
      URL                   termsofService;
      Map< String, String > features;
   }

   static class Observation
   {
      Map< String, String > image;
      Map< String, String > display_location;
      // TODO: complete me
   }

   static class Location
   {
      // TODO: complete me
   }

   static class Answer
   {
      Response    response;
      Observation current_observation;
      Location    display_location;
      // TODO: complete me
   }