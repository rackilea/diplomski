while (x) {
   in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
   reply = in.readLine();
   if (reply != null) {
      x = false;
   }
}