package so;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.Base64;
import java.util.Scanner;


import com.sun.net.httpserver.*;

public class LoadImage {

    public static void main(String[] args) throws IOException {
         HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
         server.createContext("/save_file",FileSaveHandler());
         server.createContext("/", indexHandler());
         server.start();
         System.out.println("Server started");
         Scanner scanner = new Scanner(System.in);
         scanner.nextLine();
         System.out.println("Server stopped");
         server.stop(0);
    }

    private static HttpHandler indexHandler() {
        return new HttpHandler() {
            @Override
            public void handle(HttpExchange exchange) throws IOException {
                File f = new File("index.html");
                try(OutputStream responseBody = exchange.getResponseBody();InputStream in =  new FileInputStream(f);){
                    byte[] buffer = new byte[(int)f.length()];
                    in.read(buffer);
                    exchange.sendResponseHeaders(200, buffer.length);
                    responseBody.write(buffer);
                }
            }
        };
    }

    private static HttpHandler FileSaveHandler() {
        return new HttpHandler() {

            @Override
            public void handle(HttpExchange exchange) throws IOException {

                try(InputStream in = exchange.getRequestBody();
                    OutputStream out = new FileOutputStream("out.jpg")){

                    byte [] buffer = new byte[3*1024];
                    ByteArrayOutputStream bos = new ByteArrayOutputStream();
                    int l = 0;
                    while((l=in.read(buffer))>=0){
                        bos.write(buffer, 0, l);
                    }
                    byte[] data = Base64.getDecoder().decode(bos.toByteArray());
                    out.write(data);
                }

            }
        };
    }
}