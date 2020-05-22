l1 = (LinearLayout) findViewById(R.id.l1);
    l2 = (LinearLayout) findViewById(R.id.l2);
    uptodown = AnimationUtils.loadAnimation(this, R.anim.uptodown);
    downtoup = AnimationUtils.loadAnimation(this, R.anim.downtoup);
    l1.setAnimation(uptodown);
    l2.setAnimation(downtoup);
    startActivity(intent); //<<<<<<<<<<<<<<,