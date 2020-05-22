package test;
import java.io.FileOutputStream;
public class Test {
public static void main(String[] args) throws Exception {
    StringBuilder sb = new StringBuilder();
    sb.append("[카운터] sysprop=[").append(System.getProperty("cenv"));
    if (args.length > 0) {
        sb.append("], cmd args=[").append(args[0]);
    }
    sb.append("], file.encoding=").append(System.getProperty("file.encoding"));
    FileOutputStream fout = new FileOutputStream("/testout");
    fout.write(sb.toString().getBytes("UTF-8"));
    fout.close();//write result to a file instead of System.out
    //Thread.sleep(10000);//For checking arguments using Process Explorer
}
}