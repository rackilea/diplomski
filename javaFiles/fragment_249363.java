import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.sun.org.apache.xml.internal.security.utils.Base64;

public class hData implements Serializable {
    String Symbol;
    double Position;

    public hData( String Symbol, double Position){

        this.Symbol = Symbol;
        this.Position = Position;
    }
    public static String objectToString(Serializable object) {
           String encoded = null;

           try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(object);
            objectOutputStream.close();
            encoded = new String(Base64.encode(byteArrayOutputStream.toByteArray()));
           } catch (IOException e) {
            e.printStackTrace();
           }
           return encoded;
          }
    public static void main(String[] args){
        List<hData> HData = new ArrayList<hData>(); 
        HData.add(new hData("hi", 1.2));
        String hd = objectToString((Serializable) HData);
        System.out.print(hd);
    }
}