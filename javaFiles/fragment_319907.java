final ImageView v = (ImageView) findViewById(R.id.button0);
        v.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View arg0, MotionEvent arg1) {
                switch (arg1.getAction()) {
                case MotionEvent.ACTION_DOWN: {
                    v.setImageBitmap(res.getDrawable(R.drawable.img_down));
                    break;
                }
                case MotionEvent.ACTION_CANCEL:{
                    v.setImageBitmap(res.getDrawable(R.drawable.img_up));
                    break;
                }
                }
                return true;
            }
        });