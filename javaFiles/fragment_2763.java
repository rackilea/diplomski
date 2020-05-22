Runnable runnable = new Runnable(Display display) {
... some methods ...
    @Override run() {
        ... your logic ...
        display.asyncExec(new Runnable() {
            run() {
            // update your gui here
            });
      ... some more logic ...
};