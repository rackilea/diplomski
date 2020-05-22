@Override
public void transformPage(View view, float position) {
    int pageWidth = view.getWidth();
    if (position < -1) {
        view.setAlpha(0);
    } else if (position <= 0) { 
        view.setAlpha(1);
        view.setTranslationX(0);
    } else if (position <= 1) { 
        view.setAlpha(1-position/2); // divide by 2 is the trick
        view.setTranslationX(pageWidth * -position);
    } else { 
        view.setAlpha(0);
    }
}