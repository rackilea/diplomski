private final LinkedList<XYDataItem> countHistory = new LinkedList<>();
   private static final int MAX_RANGE_IN_X_AXIS_FOR_XY_CHART = 121;
enter code here
   public void getDataAndRefresh( final DefaultTableXYDataset xySeriesCollection)
   {
      synchronized ( this.adsbItemMap )
      {
         int count = 0;

     if ( xySeriesCollection.getSeries( 0 ) != null )
     {
        final XYSeries xySeries = xySeriesCollection.getSeries( 0 );
        try
        {

           if ( this.counter == MAX_RANGE_IN_X_AXIS_FOR_XY_CHART )
           {
              xySeries.getItems().forEach( item -> {
                 final XYDataItem xyItem = ( XYDataItem ) item;
                 this.countHistory.addLast(
                       new XYDataItem( xyItem.getXValue()+1,xyItem.getYValue()));
              } );
              //xySeries.clear();
              this.countHistory.pollLast();
              this.countHistory.addFirst( new XYDataItem( 0, count ) );
              this.countHistory.forEach( xySeries::addOrUpdate );
              this.countHistory.clear();
           }
           else
           {
              xySeries.getItems().forEach( item -> {
                 final XYDataItem xyItem = ( XYDataItem ) item;
                 this.countHistory.addLast(
                       new XYDataItem( xyItem.getXValue() + 1, xyItem.getYValue() ) );
              } );
              final XYDataItem countItem = new XYDataItem( 0, count );
              this.countHistory.addFirst( countItem );
              this.countHistory.forEach( xySeries::addOrUpdate );
              this.countHistory.clear();
              this.counter++;
           }
        }
        catch ( final Exception e )
        {
           LOG.warn( "Something went wrong.", e );
        }
     }
     //clear
     total.setValue( count );
     this.adsbItemMap.clear();
  }
}