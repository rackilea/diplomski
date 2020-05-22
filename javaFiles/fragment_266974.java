synchronized(exampleLock) {
        boolean actionOneDone=false;
        boolean actionTwoDone=false;
        boolean actionThreeDone=false;
        try {
            actionOneDone=doActionOne(exampleObj);    // or perhaps exampleObj.doActionOne();
            if(actionOneDone) actionTwoDone=doActionTwo(exampleObj);
            if(actionTwoDone) actionThreeDone=doActionThree(exampleObj);
        } catch (Exception ex) {
            // Whatever seems appropriate here.
        } finally { 
            if (! (actionOneDone && actionTwoDone && actionThreeDone)) {
                /* At least one part failed.  Back out the completed actions in reverse order.  
                 * Note that we never need to reverse action three since if it completed, so did the others.
                 */
                if (actionTwoDone) {
                   reverseActionTwo(exampleObj);    // or perhaps exampleObj.reverseActionTwo();
                }
                if (actionOneDone) {
                   reverseActionOne(exampleObj);
                }
            }
        }
    }