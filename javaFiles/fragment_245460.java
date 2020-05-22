int commitInternal(boolean allowStateLoss) {
     if (mCommitted) {
         throw new IllegalStateException("commit already called");
     }
     if (FragmentManagerImpl.DEBUG) {
         Log.v(TAG, "Commit: " + this);
         LogWriter logw = new LogWriter(Log.VERBOSE, TAG);
         PrintWriter pw = new FastPrintWriter(logw, false, 1024);
         dump("  ", null, pw, null);
         pw.flush();
     }
     mCommitted = true;
     if (mAddToBackStack) {
         mIndex = mManager.allocBackStackIndex(this);
     } else {
         mIndex = -1;
     }
     mManager.enqueueAction(this, allowStateLoss);
     return mIndex;
 }