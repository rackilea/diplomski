private void StartGame() 
{
    InGame = true;
    InGrace = false;
    timeLeft = GamePeriod + GracePeriod + RankPeriod;

    GameTimer.schedule(new TimerTask() {

        @Override
        public void run() 
        {
            timeLeft = timeLeft-timerUpdate;
            if(timeLeft<=GracePeriod + RankPeriod && timeLeft>RankPeriod)
            {
                InGrace = true;
            }
            else if(timeLeft<=RankPeriod && timeLeft>0)
            {
                GameDataChange();
                InGame = false;
                InGrace = false;
            }
            else if(timeLeft<=0)
            {
                InGame = true;
                timeLeft = GamePeriod + GracePeriod + RankPeriod;
            }
        }
    }, 0, timerUpdate);