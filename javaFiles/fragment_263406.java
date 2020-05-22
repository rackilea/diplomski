@Override
public void start( Stage primaryStage )
{

    EventHandler<MouseEvent> dragDetectedHandler = (( MouseEvent event ) ->
    {
        (( ToggleButton ) event.getSource()).startFullDrag();
    });

    EventHandler<MouseDragEvent> dragEnteredHandler = (( MouseDragEvent event ) ->
    {
        (( ToggleButton ) event.getSource()).setSelected( true );
    });

    EventHandler<MouseDragEvent> onMouseDragHandler = (( MouseDragEvent event ) ->
    {
        (( ToggleButton ) event.getSource()).fire();
    });

    EventHandler<ActionEvent> onActionHandler = (( ActionEvent event ) ->
    {
        ToggleButton b = ( ToggleButton ) event.getSource();
        System.out.println( "Action on " + b.getText() );

        // without the following settings the button is not getting selected
        // and focused when fire() is triggered within onMouseDragHandler.
        b.setSelected( true );
        b.requestFocus();
    });

    VBox vBox = new VBox();

    ToggleButton tb1 = new ToggleButton( "A" );
    ToggleButton tb2 = new ToggleButton( "B" );
    ToggleButton tb3 = new ToggleButton( "C" );

    ToggleGroup group = new ToggleGroup();
    tb1.setToggleGroup( group );
    tb2.setToggleGroup( group );
    tb3.setToggleGroup( group );

    tb1.setOnAction( onActionHandler );
    tb2.setOnAction( onActionHandler );
    tb3.setOnAction( onActionHandler );

    tb1.setOnDragDetected( dragDetectedHandler );
    tb2.setOnDragDetected( dragDetectedHandler );
    tb3.setOnDragDetected( dragDetectedHandler );

    tb1.setOnMouseDragEntered( dragEnteredHandler );
    tb2.setOnMouseDragEntered( dragEnteredHandler );
    tb3.setOnMouseDragEntered( dragEnteredHandler );

    tb1.setOnMouseDragReleased( onMouseDragHandler );
    tb2.setOnMouseDragReleased( onMouseDragHandler );
    tb3.setOnMouseDragReleased( onMouseDragHandler );

    vBox.getChildren().addAll( tb1, tb2, tb3 );

    Scene scene = new Scene( vBox, 150, 150 );
    primaryStage.setScene( scene );
    primaryStage.show();
}