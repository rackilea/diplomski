int i=0;
int total_time=250*left_num*right_num;
private CountDownTimer counter = new CountDownTimer(total_time, 250) {

        public void onTick(long millisUntilFinished) {
            int u=i%left_num+1,v=i/left_num+1;
            int resourceId = this.getResources().getIdentifier("c"+u+"_r"+v, "id", this.getPackageName());
            ImageButton imageButton = (ImageButton) findViewById(resourceId);
            imageButton.setBackgroundResource(R.drawable.white_circle);
            i++;
        }

        public void onFinish() {

        }
    };