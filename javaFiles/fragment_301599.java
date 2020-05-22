import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class BatchExecuteService {

    public static void main(String[] args) {
        BatchExecuteService batchExecuteService = new BatchExecuteService();
        batchExecuteService.run();
    }

    public void run() {
        try {
            String cmds[] = {"D:\\test.bat"};
            Runtime runtime = Runtime.getRuntime();
            Process process = runtime.exec(cmds);
            process.getOutputStream().close();
            InputStream inputStream = process.getInputStream();
            InputStreamReader inputstreamreader = new InputStreamReader(inputStream);
            BufferedReader bufferedrReader = new BufferedReader(inputstreamreader);
            String strLine = "";
            while ((strLine = bufferedrReader.readLine()) != null) {
                System.out.println(strLine);
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}