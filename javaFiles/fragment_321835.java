+@SpringBootApplication
 public class WebAppInitializer extends SpringBootServletInitializer {

+        @Override
+       protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
+               return application.sources(App.class);
+       }