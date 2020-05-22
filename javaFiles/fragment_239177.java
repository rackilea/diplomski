package DI;

     import org.springframework.stereotype.Service;

     @Service("writer")
     public class Writer implements IWriter {
     public void writer (String s){
      System.out.println(s);
     }
    }