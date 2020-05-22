Thread.setDefaultUncaughtExceptionHandler( new Thread.UncaughtExceptionHandler() {
    public void uncaughtException( final Thread t, final Throwable e ) {
       ...
       // Here we offer our user the possibility to 'report' the exception, YMMV
    }
 }