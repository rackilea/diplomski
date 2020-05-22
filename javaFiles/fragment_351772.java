class MyActivity extends Activity
{
    private void executeLoop()
    {
        Handler myHandler = new Handler() 
        {
            public void handleMessage(Message msg) 
            {
                if (isShownPing) 
                {
                    detailToolbar_ping.setVisibility(View.VISIBLE);

                    if (checkSocketPingTimer > 500) {
                        detailToolbar_ping.setText(checkSocketPingTimer + "");
                        detailToolbar_ping.setTextColor(Color.RED);

                    } else {
                        detailToolbar_ping.setText(checkSocketPingTimer + "");
                        detailToolbar_ping.setTextColor(Color.GREEN);
                    }
                } else 
                {
                    detailToolbar_ping.setVisibility(View.GONE);
                }

            }
        }

        socketPingTimer.scheduleAtFixedRate(new TimerTask() 
        {
            @Override
            public void run() 
            {
                if (isSendSocketPing) 
                {
                    checkSocketPingTimer += startSocketPingTimer;
                    if (checkSocketPingTimer == sendSocketPingTimer) {
                        currentTimerForSocket = System.currentTimeMillis();
                        try {
                            detailSocketUtils.getSendRTTforPing(currentTimerForSocket + "");
                        } catch (Exception e) {
                        }
                    }

                    myHandler.sendEmptyMessage();

                    socketPing = checkSocketPingTimer;
                }
            }
        }, 500, startSocketPingTimer);
    }

}