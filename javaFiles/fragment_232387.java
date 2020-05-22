view.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {

            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                v.removeOnLayoutChangeListener(this);
                int cx = getArguments().getInt(MOTION_X_ARG);
                int cy = getArguments().getInt(MOTION_Y_ARG);
                int width = getResources().getDimensionPixelSize(R.dimen.fragment_appointment_width);
                int height = getResources().getDimensionPixelSize(R.dimen.fragment_appointment_height);

                float finalRadius = Math.max(width, height) / 2 + Math.max(width - cx, height - cy);
                Animator anim = ViewAnimationUtils.createCircularReveal(v, cx, cy, 0, finalRadius);
                anim.setDuration(500);
                anim.start();
            }
        });