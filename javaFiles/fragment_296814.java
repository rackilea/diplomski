ViewTreeObserver vto = v.getViewTreeObserver();
vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {

@Override
public void onGlobalLayout() {
if (v != null && getActivity() != null) {
    ViewTreeObserver obs = v.getViewTreeObserver();

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
        obs.removeOnGlobalLayoutListener(this);
    } else {
        obs.removeGlobalOnLayoutListener(this);
    }
    int i = v.getHeight();

    }
 }
});