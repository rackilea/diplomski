import org.apache.http.client.methods.HttpPost
import org.apache.http.entity.InputStreamEntity
import org.apache.http.impl.client.CloseableHttpClient
import org.apache.http.impl.client.HttpClients

CloseableHttpClient client = HttpClients.createDefault();

HttpPost post = new HttpPost("http://example.com");
File file = new File("/path/to/your/file");

InputStreamEntity reqEntity = new InputStreamEntity(new FileInputStream(file), -1, "Your file mime type");

//Alternatively:
//FileEntity reqEntity = new FileEntity(file, "Your file mime type");

reqEntity.setChunked(true);

client.execute(post)