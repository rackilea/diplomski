// Call this when your activity is done
// and should be closed. The ActivityResult
// is propagated back to whoever launched
// you via onActivityResult().
public void finish() {
    if (mParent == null) {
        int resultCode;
        Intent resultData;
        synchronized (this) {
            resultCode = mResultCode;
            resultData = mResultData;
        }
        if (false) Log.v(TAG, "Finishing self: token=" + mToken);
        try {
            if (resultData != null) {
                resultData.prepareToLeaveProcess();
            }
            if (ActivityManagerNative.getDefault()
                .finishActivity(mToken, resultCode, resultData)) {
                mFinished = true;
            }
        } catch (RemoteException e) {
            // Empty
        }
    } else {
        mParent.finishFromChild(this);
    }
}