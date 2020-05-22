package DI;

      import org.springframework.beans.factory.annotation.Autowired;
      import org.springframework.beans.factory.annotation.Qualifier;
      import org.springframework.stereotype.Service;

      @Service
      public class MySpringBeanWithDependency {

     @Autowired
     @Qualifier("writer")//if you need to autowire Writer service   
     private IWriter writer;

     @Autowired
    @Qualifier("niceWriter")//if you need to autowire NiceWriter service
    private IWriter niceWriter


       public void run() {
       String s = "This is my test";
        writer.writer(s);
      }
    }