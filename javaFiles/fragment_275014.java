public boolean  postDelayed(Runnable action, long delayMillis) {  
    final AttachInfo attachInfo = mAttachInfo;

    if (attachInfo != null) {
        return attachInfo.mHandler.postDelayed(action, delayMillis);
    }

    // Assume that post will succeed later
    ViewRootImpl.getRunQueue().postDelayed(action, delayMillis);
    return true;
}