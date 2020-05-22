private boolean mClicked = false;

public void act1 (View view) {
    if(mClicked) {
        ic1.setBackground(ic1dark);
    }
    else {
        ic1.setBackground(ic1light);
    }

    mClicked = !mClicked;
}