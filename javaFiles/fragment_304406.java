@Override
public boolean onScale(ScaleGestureDetector detector) { 
    float mScaleFactor = detector.getScaleFactor();
    setScaleFactor(mScaleFactor, detector.getFocusX(), detector.getFocusY());

    return true;
}