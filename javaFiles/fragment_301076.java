public class ClientFactoryBean implements FactoryBean<Client>{

   private String ipAddress;

   private int port;

   public Class<?> getObjectType(){
       return Client.class;
   }

   public boolean isSingleton(){
      return true;
   }

   public void setPort(int port){
      this.port = port;
   }

   public void setIpAddress(String ipAddress){
      this.ipAddress = ipAddress;
   }

   public Client getObject(){
      return new TransportClient().addTransportAddress(new InetSocketTransportAddress(ipAddress,port));
   }
}