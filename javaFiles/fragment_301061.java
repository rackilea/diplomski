public static final ThreadStatus threadStatus = new ThreadStatus();

public static class ThreadStatus {
 private Exception exception = null;

 public void setException(Exception exception) {
   if(exception == null) {
     return;
   }

   this.exception = exception;
 }

 public Exception getException() {
   return exception;
 }

 public boolean exceptionThrown() {
   return exception != null;
 }