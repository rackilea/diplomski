@Configuration
public class ThingUpdaterConfiguration {

     @Bean
     public Runnable thingUpdater(Thing thing) {
          return new Runnable() {
               public void run() {
                    thing.update();
               }
          }
     }
}