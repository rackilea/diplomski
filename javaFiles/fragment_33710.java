class ThreadTask implements Runnable {
    public void run() {
       // task code
    }
}

...

exec.submit(new ThreadTask());
// alternatively, using an anonymous type
exec.submit(new Runnable() {
           public void run() {
              // task code
           }
      });