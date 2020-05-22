RelativeLayout relativeLayout = new RelativeLayout(this);
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        relativeLayout.setLayoutParams(lp);


        ImageView im = new ImageView(this);
        im.setLayoutParams(new RelativeLayout.LayoutParams(50, 50));
        im.setImageResource(R.color.accent);
        ImageView im2 = new ImageView(this);
        im2.setScaleType(ImageView.ScaleType.FIT_XY);
        im2.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT));
        im2.setImageResource(R.color.orderProcessing);
        relativeLayout.addView(im2);
        relativeLayout.addView(im);
        setContentView(relativeLayout);