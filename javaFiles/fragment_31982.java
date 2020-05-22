package my;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.FormBodyPartBuilder;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.File;
import java.io.IOException;

class JenkinsClientExample {
    void helloJenkins() throws IOException {

        String server = "localhost";
        String jenkinsHost = "http://" + server + ":8080";
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
        HttpClient httpClient = httpClientBuilder.build();


        String payLoad="{ \"parameter\": [{\"name\":\"FILE1_PARAM\",\"file\":\"file0\"}, {\"name\":\"FILE2_PARAM\",\"file\":\"file1\"},{\"name\":\"STRING_PARAM\", \"value\":\"2014\"}, " +
                "{\"name\":\"BOOLEAN_PARAM\", \"value\":\"TRUE\"}  ] }";
        File file = new File("c:/dummy.txt");
        File file2 = new File("c:/another.txt");


        FormBodyPartBuilder formBodyPartBuilder3 = FormBodyPartBuilder.create("file0", new FileBody(file, ContentType.TEXT_PLAIN));
        FormBodyPartBuilder formBodyPartBuilder4 = FormBodyPartBuilder.create("file1", new FileBody(file2, ContentType.TEXT_PLAIN));
        FormBodyPartBuilder formBodyPartBuilder1 = FormBodyPartBuilder.create("json", new StringBody(payLoad, ContentType.TEXT_PLAIN));

        HttpEntity entity = MultipartEntityBuilder
                .create()

                .addPart(formBodyPartBuilder3.build())
                .addPart(formBodyPartBuilder4.build())
                .addPart(formBodyPartBuilder1.build())
                .setMode(HttpMultipartMode.BROWSER_COMPATIBLE)
                .build();

        //must be the build URL not buildWithParameters
        HttpPost httpPost = new HttpPost(jenkinsHost + "/job/fake.UpdateCQ_VersionFixed/build"); 
        httpPost.setEntity(entity);

        HttpResponse response = httpClient.execute(httpPost);
        HttpEntity result = response.getEntity();
        System.out.println(result);
        System.out.println(response.toString());

    }

    public static void main(String[] args) {
        try {
            new JenkinsClientExample().helloJenkins();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}