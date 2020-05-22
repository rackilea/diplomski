public void ManageStamina()
{
    new Thread(new Runnable() {
        @Override
        public void run() {
                while (progressBarStatus < 100){
                    mHandler.post(new Runnable(){
                        public void run(){
                            mProgress.setProgress(progressBarStatus);
                        }
                    });
                }
            }
        });

}