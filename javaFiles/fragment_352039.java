public static Provider getInstance() {
  /*
  try {
     try {
        return new StreamProvider();
     } catch(Throwable e) {
        return new PullProvider();
     }
  } catch(Throwable e) {
     return new DocumentProvider();
  }
  */
  try {
     return new PullProvider();
  } catch (Exception e) {
     e.printStackTrace();
  }
  return new DocumentProvider();
 }