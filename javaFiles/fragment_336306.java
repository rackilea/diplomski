AccessToken token = null;
try {
   token = ApplicationManager.getApplication().acquireReadActionLock();
                    //do what you need
} finally {
   token.finish();
}