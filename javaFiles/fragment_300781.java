TextView logo1 = (TextView) findViewById(R.id.TextViewTopTitle);
    Animation fade1 = AnimationUtils.loadAnimation(this, R.anim.fade_in);
    logo1.startAnimation(fade1); // <----- is this right?

    TextView logo2 = (TextView) findViewById(R.id.BottomView1);
    Animation fade3 = AnimationUtils.loadAnimation(this, R.anim.fade_in);
    logo1.startAnimation(fade3); // <----- and this one?