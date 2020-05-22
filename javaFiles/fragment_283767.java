WeatherModel weatherModel = new WeatherModel();
weatherModel.setArea( myAreaData[areaIdx] );
  for( int partIdx = 0 ; partIdx< 7; partIdx++ )
  {
     Interval interval = new Interval();
     interval.setDescription( myPartData[partIdx] );
     weatherModel.getIntervals().add(interval);


  }