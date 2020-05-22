// that's on the background thread
line #288: return postResult(doInBackground(mParams)); 

private Result postResult(Result result) {
        @SuppressWarnings("unchecked")
        Message message = sHandler.obtainMessage(MESSAGE_POST_RESULT,
                new AsyncTaskResult<Result>(this, result));
        // here it sends the message to the intenral UI handler
        message.sendToTarget(); 
        return result;
    }