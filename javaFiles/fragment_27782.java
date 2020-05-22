package com.kundan.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class GetWithBody {

    public static final String TYPE = "GET ";
    public static final String HTTP_VERSION = " HTTP/1.1";
    public static final String LINE_END = "\r\n";

    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 8080); // hostname and port default is 80
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write((TYPE + "<Resource Address>" + HTTP_VERSION + LINE_END).getBytes());// 
        outputStream.write(("User-Agent: Java Socket" + LINE_END).getBytes());
        outputStream.write(("Content-Type: application/x-www-form-urlencoded" + LINE_END).getBytes());
        outputStream.write(LINE_END.getBytes()); //end of headers
        outputStream.write(("parameter1=value&parameter2=value2" + LINE_END).getBytes()); //body 
        outputStream.flush();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        StringBuilder builder = new StringBuilder();
        String read = null;
        while ((read = bufferedReader.readLine()) != null) {
            builder.append(read);
        }

        String result = builder.toString();
        System.out.println(result);
    }
}