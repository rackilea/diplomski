import java.io.File;
import org.apache.http.client.fluent.*;
import org.apache.http.entity.ContentType;

public class QuickStart {

    public static void main(String[] args) throws Exception {
        File file = new File("data.zip");
        Executor executor = Executor.newInstance()
                .auth("admin", "geoserver")
                .authPreemptive("172.16.17.86:9090");
        String response = executor.execute(Request.Put("http://172.16.17.86:9090/geoserver/rest/workspaces/IDIRA6/datastores/Murrindindi/file.shp")
                .useExpectContinue()
                .bodyFile(file, ContentType.create("application/zip")))
                .returnResponse()
                .toString();
        System.out.println(response);
    }

}