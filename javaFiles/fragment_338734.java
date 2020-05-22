@Override
public void start( Stage stage )
{
    Scene scene = new Scene( new Group(), 200, 300 );

    Alert alert = new Alert( Alert.AlertType.CONFIRMATION );
    alert.setTitle( "Confirmation Dialog" );
    alert.setHeaderText( "Look, a Confirmation Dialog" );
    alert.setContentText( "Are you ok with this?" );

    System.out.println( "timeline Started -" + Calendar.getInstance().getTime() );
    Timeline idlestage = new Timeline( new KeyFrame( Duration.seconds(5 ), new EventHandler<ActionEvent>()
    {

        @Override
        public void handle( ActionEvent event )
        {
            alert.setResult(ButtonType.CANCEL);
            alert.hide();
        }
    } ) );
    idlestage.setCycleCount( 1 );
    idlestage.play();

    Optional<ButtonType> result = alert.showAndWait();

    if ( result.get() == ButtonType.OK )
    {
        System.out.println( "ok clicked" );
    }
    else if ( result.get() == ButtonType.CANCEL)
    {
        System.out.println( "cancel clicked" );
    }

    stage.setScene( scene );
    stage.show();
}