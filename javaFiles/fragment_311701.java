public class UDPDiscoveryPacket{
      public final long sendingTime;
      public final String clientIP;
      public UDPDiscoveryPacket(long sendingTime, String clientIP){
         this.sendingTime = sendingTime;
         this.clientIP = clientIP;
      }
}