private List<SwipeableButtonListener> listeners;

public void addOnClickListener(SwipeableButtonListener listener)
{
    if(listeners == null)
        listeners = new ArrayList<SwipeableButtonListener>();

listeners.add(listener);
}

private void fireButtonSwipedListeners()
{
    if(listeners != null){
     for(SwipeableButtonListener listener: listeners){
           listener.onSwipe();}
    }
}