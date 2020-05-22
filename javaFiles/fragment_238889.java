private static boolean isFirstMove;
public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float X, float Y) {
    if (pSceneTouchEvent.isActionDown()) {
       isFirstMove = true;
    }
    if (pSceneTouchEvent.isActionMove()) {
        if(isFirstMove) {
            score++;
            isFirstMove = false;
        }
    }
    if (pSceneTouchEvent.isActionUp()) {
        isFirstMove = false;
    }
});