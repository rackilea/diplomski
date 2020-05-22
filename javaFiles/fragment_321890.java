stream.filter(fq)
try
{
    Thread.sleep(2 * 60 * 1000); // just sleep on the caller thread
}
catch (InterruptedException e)
{
    // ignore
}
stream.removeListener(listener)
stream.cleanup()
//stream.shutdown()     //don't think you really need shutdown, cleanup seems to be enough