public void addedViewTarget(final View view) {
        ViewGroup vg = ((ViewGroup) view.getParent());
        vg.removeView(view);
        view.postDelayed(new Runnable() {
            @Override
            public void run() {
                llLayout.addView(view);
            }
        },1000 );

    }