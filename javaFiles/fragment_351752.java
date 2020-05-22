public final boolean postAtTime(Runnable r, Object token, long uptimeMillis)
308    {
309        return sendMessageAtTime(getPostMessage(r, token), uptimeMillis);
310    }

private static Message getPostMessage(Runnable r, Object token) {
608        Message m = Message.obtain();
609        m.obj = token;