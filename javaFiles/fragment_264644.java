package client;

import java.io.File;
import java.util.Scanner;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.DefaultHttpClient;

public class RESTClient {

    public static void main(String args[]) throws Exception {
        File f = new File("C:/Users/Public/Pictures/Sample Pictures/Desert.jpg");
       sendFile(f);
    }
    public static void sendFile(File file) throws Exception 
    {
    String BASE_URL="http://10.1.4.126:8080/rest/KVBSvasth/getKvbMemberDetails";
        HttpClient client = new DefaultHttpClient() ;
        HttpPost postRequest = new HttpPost (BASE_URL) ;
        try
        {

            //Set various attributes 
            MultipartEntity multiPartEntity = new MultipartEntity() ;

           // multiPartEntity.addPart("fileName", new StringBody(file.getName() != null ? file.getName() : file.getName())) ;

            FileBody fileBody = new FileBody(file) ;
            //Prepare payload
            multiPartEntity.addPart("attachment", fileBody) ;

            //Set to request body
            postRequest.setEntity(multiPartEntity) ;

            Scanner sc = new Scanner(new File("C:/Users/rishabh.keshari/Desktop/json.txt"));

            postRequest.setHeader("jsondataaa",sc.nextLine());
            //Send request
            HttpResponse response = client.execute(postRequest) ;

            //Verify response if any
            if (response != null)
            {
                System.out.println(response.getStatusLine().getStatusCode());
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace() ;
        }
    }
}