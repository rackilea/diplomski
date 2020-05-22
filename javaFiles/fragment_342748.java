public static void torNewIP() throws Exception {
   Socket socket = new Socket();
   socket.connect(new InetSocketAddress(TOR_IP, TOR_CONTROL_PORT));
   socket.getOutputStream().write(new String("SIGNAL NEWNYM\r\n").getBytes());
   socket.close();
}