@Service
public class RabbitMQServices implements InitializingBean {

     RestTemplate template = new RestTemplate();

     @Override
     public void afterPropertiesSet() {

         // Create RabbitMQ management url
         this.url = "http://" + rabbitmqfqdn + ":" + rbtmqmgmtport;

         // Create http template
         template.getInterceptors()
             .add(new BasicAuthorizationInterceptor(rbtmqadminname,
                rbtmqadminpw));

}