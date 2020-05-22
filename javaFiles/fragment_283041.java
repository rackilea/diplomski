StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
 for( StackTraceElement element : stackTrace ) {
    //ignore all entries from within LoggerUtils 
    if( element.getClassName().equalsIgnoreCase( LoggerUtils.class.getName() ) ) {
      continue;
    } else {
      String method = element.getMethodName();
      int lineNo = element.getLineNumber();
      break;
    }
 }