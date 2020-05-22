public void setScaleFactor(float mScaleFactor, float focusX, float focusY) {
    float origScale = saveScale;
    saveScale *= mScaleFactor;
    if (saveScale > maxScale) {
        saveScale = maxScale;
        mScaleFactor = maxScale / origScale;
    } else if (saveScale < minScale) {
         saveScale = minScale;
         mScaleFactor = minScale / origScale;
    }

    if (origWidth * saveScale <= viewWidth || origHeight * saveScale <= viewHeight) {
        matrix.postScale(mScaleFactor, mScaleFactor, viewWidth / 2, viewHeight / 2);
    } else {
        matrix.postScale(mScaleFactor, mScaleFactor, focusX, focusY);
    }
    fixTrans();
}