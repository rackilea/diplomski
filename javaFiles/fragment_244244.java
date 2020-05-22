...
try
{
    FXMLLoader loader = new FXMLLoader( getClass().getResource( "Sample.fxml" ) );
    Scene scene = new Scene( loader.load(), 600, 400 );

    ( (MyController) loader.getController() ).setPrimaryStage(primaryStage);
    primaryStage.setScene( scene );
}
catch ( Exception e )
{
    e.printStackTrace();
}
...