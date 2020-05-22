public class Echo extends Application {

   /*
    * (non-Javadoc)
    * @see javafx.application.Application#start(javafx.stage.Stage)
    */
   @Override
   public void start(Stage primaryStage) throws Exception {

      Parameters params = getParameters();
      System.out.println("\nRaw");
      params.getRaw().forEach(e -> {
         System.out.println(e);
      });

      System.out.println("\nNamed");
      params.getNamed().keySet().forEach(key -> {
         System.out.println("key : " + key + " / value : " + params.getNamed().get(key));
      });

      System.out.println("\nUnnamed");
      params.getUnnamed().forEach(unnamed -> {
         System.out.println(unnamed);
      });

      Platform.exit();
   }

   public static void main(String[] args) {
      launch(args);
   }

}