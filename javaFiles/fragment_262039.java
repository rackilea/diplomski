public class GUI extends Application {

   // ... system variables

   public init() throws SQLException, InterruptedException {

      // ...

      List<String> args = getParameters().getRaw();

      // process parameters...

      connectionQuestions = questionssqliteConnection.dbConnector();
      connectionUsers = userssqliteConnection.UdbConnector();
   } 

   @Override
   public void start(Stage primaryStage) {
      // ...
   }
}