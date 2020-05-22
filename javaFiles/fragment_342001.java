import org.rosuda.REngine.REXP;
import org.rosuda.REngine.Rserve.*;

public class Rtemp {
public static void main(String[] args) throws Exception {
RConnection c = null;

try {
  c = new RConnection();

  //Loading RPostgreSQL library
  c.eval("library(RPostgreSQL)");
  //Loading PostgreSQL driver
  c.eval("drv <- dbDriver(\"PostgreSQL\")");

  // Establishing connection
  REXP r = c.parseAndEval("r <- try(\"dbConnect(drv, host='localhost', port='5432',dbname='r1', user='postgres', password='pwd')\",silent=TRUE)");
  if (r.inherits("try-error")) System.err.println("Error: "+r.asString());
  else System.out.println("Success eval 1");


  REXP rs = c.parseAndEval("try(rs <-dbSendQuery(r,\"select colmn1 from host_brnd345633456_table1 limit 10 \"), silent=TRUE)");
  if (rs.inherits("try-error")) System.err.println("Error: "+rs.asString());
  else System.out.println("Success eval 2");



  REXP ftch = c.parseAndEval("try(ftch <- ftch(rs,n=-1),silent=TRUE)");
  if (ftch.inherits("try-error")) System.err.println("Error: "+ftch.asString());
  else System.out.println("Success eval 3");

  REXP res = c.parseAndEval("try(res <- median(ftch$colmn1),silent=TRUE)");
  if (res.inherits("try-error")) System.err.println("Error: "+res.asString());
  else {
    System.out.println("Success eval 4");
    System.out.println(res.asDouble());
  }
  #The line 58 error mentioned below in the error section is coming at this line
  System.out.println(res.asDouble());
  //System.out.println(x.asString());
  System.out.println("Library loaded successfully");
} catch(Exception e) {
  e.printStackTrace();
} finally {
  if ( c != null )
    try {
      c.close();
    }
}