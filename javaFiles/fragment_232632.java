@Configuration
 @EnableWebSocket
 public class MyConfiguration implements WebSocketConfigurer {

        @Override
        public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
                registry.addHandler(echoWebSocketHandler(), "/echo").withSockJS();
        }

        @Bean
        public WebSocketHandler echoWebSocketHandler() {
               //FooWebSocketHandler implements your specific logic
                return new FooWebSocketHandler();
        }
 }
 public class FooWebSocketHandler extends AbstractWebSocketHandler {
   private boolean enabled;
   ...
    public void handleMessage(WebSocketSession session,
                      WebSocketMessage<?> message)
               throws Exception {
     if (enabled) {//work
     } else {
       //disabled, i.e. throw exception or send data according to your api
     }
   }
 }