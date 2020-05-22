public class TickLabelFormatterDemo extends Application
{

    private static final int RANGE = 100;
    private int last_X_Axis_Val = 20;


    @Override
    public void start( Stage stage )
    {
        stage.setTitle( "Sample" );

        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setForceZeroInRange( false);
        xAxis.setTickLabelFormatter( new StringConverter<Number>()
        {

            @Override
            public String toString( Number object )
            {
                int i = object.intValue() % RANGE;
                return String.valueOf( i == 0 ? RANGE : i );
            }

            @Override
            public Number fromString( String string )
            {
                return null;
            }
        } );

        final LineChart<Number, Number> lineChart
                = new LineChart<>( xAxis, yAxis );

        lineChart.setTitle( "Monitoring" );
        XYChart.Series series = new XYChart.Series();
        series.setName( "Values" );

        Random random = new Random();

        Timeline timeline = new Timeline( new KeyFrame( Duration.seconds( 2 ), new EventHandler<ActionEvent>()
        {
            @Override
            public void handle( ActionEvent event )
            {
                if ( series.getData().size() > 5 )
                {
                    series.getData().remove( 0 );
                }
                series.getData().add( new XYChart.Data( last_X_Axis_Val, random.nextInt( 50 ) ) );
                last_X_Axis_Val += 20;
            }
        } ) );
        timeline.setCycleCount( Timeline.INDEFINITE );
        timeline.play();

        Scene scene = new Scene( lineChart, 800, 600 );
        lineChart.getData().add( series );

        stage.setScene( scene );
        stage.show();
    }


    public static void main( String[] args )
    {
        launch( args );
    }

}