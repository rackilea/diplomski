/**
  * @param origVal string giving value, possibly null, in which case DEFAULT_VALUE is assigned
  */
void doStuff(final String origVal, ... )
{
    final String valOrDefault = (origVal == null) ? DEFAULT_VALUE : origVal; 
    // similar mucking about to make all the parameters behave, separate from
    // actually operating on them...
    ...
    reallyDoStuff(valOrDefault,...);
}

private void reallyDoStuff(final String value, ...)
{
   assert (value != null);
   // do your complex processing
}