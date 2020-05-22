//This is an inner class, with i an int in the Activity, starting at 0;
public class ScrollTimerTask extends TimerTask {

    @Override
    public void run() {
        if (i < getListView().getCount()) {
            getListView().smoothScrollToPosition(i);
            i++;
        }
        else {
            getListView().smoothScrollToPosition(0);
            i == 0;
        }
}