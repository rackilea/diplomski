//MyProg.java
package my.java
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.scala.DefaultScalaModule;

public class MyProg {

ObjectMapper mapper = new ObjectMapper().registerModule(new DefaultScalaModule());

mapper.readValue("{\"test\": false}", A.class);

mapper.readValue("""{"test": false}""", B.class);
}