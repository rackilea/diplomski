private void lapWatchAndLog( StopWatch watch, String messageForLap ) {

    watch.stop();
    LOGGER.info( String.format( "Time: [%s] %s", watch.getTime(), messageForLap ) );
    watch.reset();
    watch.start();
}