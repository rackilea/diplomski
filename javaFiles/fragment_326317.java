imageview1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            n++;
            linear1.setVisibility(View.VISIBLE);
            if (n == 1) {
                final VideoView vd = new VideoView(MainActivity.this); vd.setLayoutParams(new LinearLayout.LayoutParams(android.widget.LinearLayout.LayoutParams.MATCH_PARENT, android.widget.LinearLayout.LayoutParams.MATCH_PARENT)); linear1.addView(vd);
                vd.setVideoURI(Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.mercury));
                vd.requestFocus();
                vd.start();
            } else {
                vd.seekTo(0);
            }