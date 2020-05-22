//gloabals
final Handler handler = new Handler();
public Timer swipeTimer ;


 /** 
 *  this function swipes pages left to right for every 7 seconds
 * @param myPager its viewpager.
 * @param time as second, for 7 second enter 7
 *
 */
public void setTimer(final ViewPager myPager, int time){
     final int size =objects.size();


        final Runnable Update = new Runnable() {
            int NUM_PAGES =size;
            int currentPage = 0 ;
            public void run() {
                if (currentPage == NUM_PAGES ) {
                    currentPage = 0;
                }
                myPager.setCurrentItem(currentPage++, true);
            }
        };

        swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {

            @Override
            public void run() {
                handler.post(Update);
            }
        }, 1000, time*1000);
}