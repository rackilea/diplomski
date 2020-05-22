package org.counter.biz;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class MyClassLoader extends ClassLoader {

    private Socket clientChannel;
    private int count = 0;

    public MyClassLoader(Socket channel){
        this.clientChannel = channel;
    }

    @Override
    protected Class findClass(String className){

        Class myClass = null;

        InputStream inputStream = null;

        try {
            inputStream = clientChannel.getInputStream();
        }catch (IOException e){e.printStackTrace();}


        byte[] bytes = new byte[8192];
        byte[] myBytes = null;

        try {
            while ((count = inputStream.read(bytes)) > 0){
                myBytes = new byte[count];
                System.arraycopy(bytes, 0, myBytes, 0, count);
                myClass = defineClass(className, myBytes, 0, myBytes.length);
            }
            inputStream.close();
        }catch (IOException io){}


        return myClass;

    }

}