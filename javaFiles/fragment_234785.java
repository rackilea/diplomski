package com.integral.ie.theme;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class suggest extends HttpServlet implements
javax.servlet.Servlet {
    Properties props=null;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        //super.doPost(req, resp);
        final int maxRead=200;

        String result="";
        String args=req.getQueryString();
        String baseURL=props.getProperty("searchFormBaseURL");
        String urlStr=baseURL+"/suggest?"+args;
        //System.out.println("Search suggestion URL: "+urlStr);
        try {
            int rCount=0;
            int totalCount=0;
            int baLen=maxRead;
            byte[] ba=null;
            byte[] bCopy;
            URL url=new URL(urlStr);
            HttpURLConnection conn=(HttpURLConnection)url.openConnection();
            conn.setRequestMethod("POST");
            // Setting these properties may be unnecessary - just did it
            // because the GSA javascript does it.
            conn.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
            conn.setRequestProperty("Content-Length","0");

            InputStream is=conn.getInputStream();
            ba=new byte[baLen];
            while (rCount>=0) {
                try {
                    rCount=is.read(ba,totalCount,baLen-totalCount);
                    if (rCount>0) {
                        totalCount+=rCount;
                        if (totalCount>=baLen) {
                            baLen+=maxRead;
                            bCopy=new byte[baLen];
                            System.arraycopy(ba,0,bCopy,0,totalCount);
                            ba=bCopy;
                            bCopy=null;
                        }
                    }
                } catch(IOException e) {
                    // IOException while reading - allow the method to return
                    // anything we've read so far.
                }
            }

            is.close();
            conn.disconnect();
            result=(totalCount==0?"":new String(ba,0,totalCount));

            //System.out.println("Search suggestion result length: "
            //+Integer.toString(result.length()));

        } catch(MalformedURLException e) {
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        }
        PrintWriter pw=resp.getWriter();
        pw.print(result);
    }

    @Override
    public void init() throws ServletException {
        super.init();
        InputStream stream=this.getClass().getResourceAsStream("/WEB-INF/lib/endeavour.properties");
        props=new Properties();
        try {
            props.load(stream);
            stream.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}