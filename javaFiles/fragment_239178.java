package DI;

    import org.springframework.stereotype.Service;

   @Service("niceWriter")
   public class NiceWriter implements IWriter {
   public void writer (String s){
    System.out.println("The string is " + s);
   }
  }