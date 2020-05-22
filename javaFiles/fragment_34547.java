try {
          BufferedOutputStream os = new BufferedOutputStream(thread_cnn.getOutputStream());
          OutputStreamWriter osw = new OutputStreamWriter(os, "US-ASCII");
          osw.write("areyoustillthere\n");
          osw.flush();

} catch (Exception e) { 
           quit(); // handle quit if server can't reach client
}