public interface StuffObserver {
/**
 * 
 * Pass whatever you want, perhaps getStuff(),
 * but that method might be removed by the time we're done here
 * (depends on what else might need to query/track it without,
 *  an observer)
 */
private void onStuffChanged(String newStuff);