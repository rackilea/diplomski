import org.apache.log4j.Logger;
....
public class example{

static Logger log = Logger.getLogger(this.class);

.....
public void test(){
 String hello ="Hello World";
 log.trace(hello);
}
....
}

output will be :
TRACE:(<classname>){2011-10-38-06:644} Hello World 2011-05-10 08:38:06,644