import java.io.*;
      import org.rosuda.JRI.*;
      public class Prova {
         public static void main(String[] args) {
           String[] commands = {"a<-try(dbGetQuery(conn,'show tables'))","a<-try(dbGetQuery(conn,'SS'))"};
           Rengine re=new Rengine (new String [] {"--vanilla"}, false, null);
           re.eval("require(RMySQL)");
           re.eval("conn<-dbConnect(MySQL(),user='xxx',password='xxx',dbname='xxx')");
           for (int i=0;i<2;i++) {
             REXP y = re.eval(commands[i]);
             REXP x = re.eval("class(a)");
             if ((x.asString()).equals("try-error")) {
               System.out.println(y.asString());
             } else {
               System.out.println(x.asString());
             }
           }
           re.end();
         }
      }