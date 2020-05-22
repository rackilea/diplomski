DefaultExtractorsFactory extractorFactory = new DefaultExtractorsFactory();

DefaultBandwidthMeter BANDWIDTH_METER = new DefaultBandwidthMeter();

DataSource.Factory mediaDataSourceFactory =  new DefaultDataSourceFactory(this, (TransferListener<? super DataSource>) BANDWIDTH_METER, httpDataSourceFactory);

ExtractorMediaSource mediaSource mediaSource =  new ExtractorMediaSource.Factory(mediaDataSourceFactory).
setExtractorsFactory(extractorFactory).
createMediaSource(uri);