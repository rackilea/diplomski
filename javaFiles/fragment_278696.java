public  boolean finish(){

    boolean result      = false;
    int     retryCount  =  0;

    try
    {
        if( !this.latch.await( 5, TimeUnit.SECONDS ) )
        {
            Util.warn(LOG,"Timed-out -- msg #", String.format("%0,4d", this.msgId) );
        }

        this.httpClient.stop();
        result = this.httpClient.isStopped();
    }
    catch (InterruptedException ex )
    {
        log.warn("Interrupted -- msg #", String.format("%0,4d", this.msgId)" );
    }
    catch (Exception ex)
    {
        log.error(LOG,"Stop-exception -- msg #", String.format("%0,4d", this.msgId) );
    }

    if( !result )
    {
        log.warn(" * HttpClient NOT stopped -- msg #", String.format("%0,4d", this.msgId) );
    }

    return  result;
}