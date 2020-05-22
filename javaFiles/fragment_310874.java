import java.io.File;
import org.rosuda.JRI.REXP;
import org.rosuda.JRI.Rengine;


public class RunDavid {


public static void main (String args []) {


 Rengine re = new Rengine (new String [] {"--vanilla"}, false, null);

 System.out.println("R_HOME =" + System.getenv("R_HOME"));
  String path =System.getenv("R_HOME") + "\\library" ;
   File folder = new File(path);
  File[] listOfFiles = folder.listFiles();

    for (int i = 0; i < listOfFiles.length; i++) {
      if (listOfFiles[i].isFile()) {
        System.out.println("File " + listOfFiles[i].getName());
      } else if (listOfFiles[i].isDirectory()) {
        System.out.println("Directory " + listOfFiles[i].getName());
      }
    }

re.eval("library(e1071)");
re.eval("data(HouseVotes84, package = 'mlbench'))");
re.eval("model <- naiveBayes(Class ~ ., data = HouseVotes84)");
re.eval("NBC <- model$tables");
REXP  t = re.eval("NBC$V1[1]");
System.out.println(t.asDouble());
}}