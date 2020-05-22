@Override
public boolean onAreaTouched(TouchEvent pSceneTouchEvent,
    float pTouchAreaLocalX, float pTouchAreaLocalY) {
                if (pSceneTouchEvent.isActionDown()) {
                      // start X,Y
                }
                if (pSceneTouchEvent.isActionMove()) {
                      //what to do on move
                }
        if (pSceneTouchEvent.isActionUp()) {
                      // end X,Y
        }
    return super.onAreaTouched(pSceneTouchEvent, pTouchAreaLocalX,              pTouchAreaLocalY);

}