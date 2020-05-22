public static String ping(String ip, int timeoutMs) {
   // returns ping output as a String, or error if timeout reached
}

public static String telnet(String ip, int port, String command, int timeoutMs) {
   // returns output of ssh -c command to chosen ip:port
   // must have public-key login to chosen machine for this to work 
   //   without password prompts
   // returns error description if timeout reached 
}