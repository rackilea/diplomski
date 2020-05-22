// GLOBAL VARIABLES
CountDownTimer points_timer;
int bonus_time = 1 , sec = 10000 , point == 0; 

public void createTimer()
{
    points_timer =new CountDownTimer(sec,1000) {

        @Override
        public void onTick(long millisUntilFinished) 
        {
            sec = millisUntilFinished;

            if ( point == (bonus_time * 20))
            {
                ++bonus_time;
                //millisUntilFinished += 10000;
                sec += 10000;
                createTimer();
            }

            ++point;
        }

        @Override
        public void onFinish() 
        {
            bonus_time = 1;
        }
    };
}