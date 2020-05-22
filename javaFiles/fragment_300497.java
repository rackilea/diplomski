int height = displaymetrics.heightPixels;
    int width = displaymetrics.widthPixels;
    int buttonWidth = 150;
    int buttonHeigh = 40;
    int max_x_val = width - buttonWidth;
    int max_y_val = heigth - buttonHeigh; // Edited here

    for(int x = 0;x<10;x++) {

        Button btn = new Button(this);

        int Xpoistion = rnd.nextInt(max_x_val - buttonWidth) + buttonWidth;
        int Yposition = rnd.nextInt(max_y_val - buttonHeigh) + buttonHeigh;

        btn.setX(Xpoistion);
        btn.setY(Yposition);
        btn.setWidth(buttonWidth);
        btn.setHeight(buttonHeigh);
        btn.setText(x +")"+width + "," + height + " | " + Xpoistion + "," + Yposition);

        relativeLayout.addView(btn);
        Log.d("Debug","Xpos =" + Xpoistion);
        Log.d("Debug","Ypos =" + Yposition);
    }