import java.io.BufferedOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.StaxDriver;



class Data {
    String UUID;
    String location;
    String name;
    String age;

    public Data(String[] elements){
        int i = 0;
        UUID = elements[i++].trim();
        location = elements[i++].trim();
        name  = elements[i++].trim();
        age = elements[i++].trim();
    }

}