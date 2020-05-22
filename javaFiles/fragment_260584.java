@JmsListener(
destination = "venta.topic",
id = "comercial",
subscription = "venta.topic",
//this was also needed with the same name as the bean above
containerFactory = "jmsListenerContainerFactory" 
)
public void receiveMessage(Venta venta) {
            logger.log(Level.INFO, "RECEIVED : {0}",venta);      
            repository.save(venta);
}