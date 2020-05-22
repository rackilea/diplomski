public void run() {
   String msg = null;
   while(true) {  // Or whatever your exit condition is...
      try {
         msg = inputStream.readLine();
      } catch(IOException e) {
         // Handle properly.
      }
      if (msg != null && msg != "") {
          NotifyAndForwardMessage(msg);
      }
   }
}