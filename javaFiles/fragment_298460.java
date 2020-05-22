RelativeLayout toastLayout = new RelativeLayout(this);
    RelativeLayout.LayoutParams llp = new RelativeLayout.LayoutParams(
            LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
    toastLayout.setLayoutParams(llp);

    ImageView toastImg = new ImageView(this);
    Bitmap toastBitmap = BitmapFactory.decodeResource(getResources(),
            R.drawable.like);
    toastImg.setImageBitmap(toastBitmap);

    TextView toastText = new TextView(this);
    toastText.setText("J'aime !");

    RelativeLayout.LayoutParams toastTextLp = new RelativeLayout.LayoutParams(
            LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
    toastTextLp.addRule(RelativeLayout.CENTER_HORIZONTAL);
    toastTextLp.setMargins(0, 85, 0, 0);
    toastText.setLayoutParams(toastTextLp);

    toastLayout.addView(toastImg);
    toastLayout.addView(toastText);

    Toast toast = new Toast(this);
    toast.setView(toastLayout);