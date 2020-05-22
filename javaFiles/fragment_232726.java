// for button placement purely design workout
        DisplayMetrics displayMetrics = this.getResources().getDisplayMetrics();

        float dpHeight = displayMetrics.heightPixels / displayMetrics.density;
        float dpWidth = displayMetrics.widthPixels / displayMetrics.density;

        Log.e("Screen height:", "" + dpHeight);
        RelativeLayout rl = (RelativeLayout) findViewById(R.id.main_relative_layout);
        rl.getLayoutParams().height = dpToPx((int) dpHeight - 70);