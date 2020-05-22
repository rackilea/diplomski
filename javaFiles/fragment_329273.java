package com.excel2pdfconvert.example;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.DefaultHttpClient;

public class Xls2PDFConvertBean {

    private File file;
    private String outputDir;


    private String filesize;
    private String filename;



    public void setOutputDir(String outputDir) {
        this.outputDir = outputDir;
    }
    public void setExcelFile(File file) {
        this.file = file;
    }

    public String getFilesize() {
        return filesize;
    }
    public String getFilename() {
        return filename;
    }


    /**
     * Run request for page conversion
     * @return resultcode "0" in error, "1" in success
     * @throws UnsupportedEncodingException 
     */
    public String doRequest() throws UnsupportedEncodingException{

        String resultcode = "0"; 

        HttpPost httppost = new HttpPost("http://do.convertapi.com/Excel2Pdf");

        MultipartEntity entity = new MultipartEntity( HttpMultipartMode.BROWSER_COMPATIBLE );

        // For File parameters
        entity.addPart("file", new FileBody(file, "binary/octet-stream"));

        httppost.setEntity( entity );

        HttpClient httpclient = new DefaultHttpClient();
        try {
            HttpResponse response = httpclient.execute(httppost);
            Header rcHeader = response.getFirstHeader("result");
            if(rcHeader != null){

                resultcode = rcHeader.getValue();

                if("True".equals(resultcode)){

                    filesize = response.getFirstHeader("filesize").getValue();
                    filename = response.getFirstHeader("OutputFileName").getValue();

                    HttpEntity hentity = response.getEntity();
                    if(hentity != null){

                        InputStream istream = hentity.getContent();
                        File file = new File(outputDir+File.separator+filename);
                        FileOutputStream ostream = new FileOutputStream(file);

                        byte[] b = new byte[1024];
                        int num = 0;
                        while( (num = istream.read(b, 0, b.length)) > 0)
                            ostream.write(b, 0, num);
                        istream.close();
                        ostream.flush();
                        ostream.close();

                    }
                }
            }

        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return resultcode;
    }

}