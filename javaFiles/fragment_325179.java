public class MyTimerTask extends TimerTask {

    @Override
    public void run() {
       flag = true;
       while(flag && (getActivity() != null))
       {try {
           Thread.sleep(1000);
        getActivity().runOnUiThread(new Runnable() {

            @Override
            public void run() {
                updateTextView();

            }
        });
    }catch (InterruptedException e){
        e.printStackTrace();
    }

    }

 }