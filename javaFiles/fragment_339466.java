import java.io.File;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.HttpResponse;
import org.apache.http.entity.FileEntity;
import org.apache.http.client.methods.HttpPut;

public class OneDriveHttpClientUpload {
    public static void main(String[] args) throws Exception {
        String accessToken = "...";
        String url = "https://apis.live.net/v5.0/me/skydrive/files/HelloWorld.txt?access_token="+accessToken;
        HttpClient apClient = HttpClients.createDefault();
        HttpPut httpPut = new HttpPut(url);
        FileEntity file = new FileEntity(new File("testfile.txt"));
        httpPut.setEntity(file);
        HttpResponse ret = apClient.execute(httpPut);
    }
}