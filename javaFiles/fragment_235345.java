mFlipper = ((ViewFlipper) this.findViewById(R.id.splash_more_flipper));

    Button next = (Button) findViewById(R.id.next);
        next.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                mFlipper.showNext();
                mContainer.startAnimation(anim);
            }
        });
    }