public class XYLineChart_AWT extends javax.swing.JFrame  
{

   int[] array;

   public XYLineChart_AWT( String applicationTitle, String chartTitle, int[] array )
   {
      super(applicationTitle);


      this.array = array;


JFreeChart xylineChart = ChartFactory.createXYLineChart(
         chartTitle ,
         "X- axis" ,
         "Y - axis" ,
         createDataset() ,
         PlotOrientation.VERTICAL ,
         true , true , false);

      ChartPanel chartPanel = new ChartPanel( xylineChart );
      chartPanel.setPreferredSize( new java.awt.Dimension( 500 , 500 ) );
      final XYPlot plot = xylineChart.getXYPlot( );
      XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer( );
      renderer.setSeriesPaint( 0 , Color.RED );
      renderer.setSeriesStroke( 0 , new BasicStroke( 4.0f ) );
      plot.setRenderer( renderer ); 
      setContentPane( chartPanel ); 
   }