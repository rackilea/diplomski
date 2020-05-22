import java.util.HashMap;
import java.util.Collection;
import java.security.*;
import java.lang.reflect.Field;

public class HelloWorld {
   public static void main(String[] args) {
    try{
      KeyStore ks = KeyStore.getInstance("WINDOWS-MY");
        ks.load(null, null);

        Field field =  ks.getClass().getDeclaredField("keyStoreSpi");
        field.setAccessible(true);

        KeyStoreSpi kss = (KeyStoreSpi) field.get(ks);

        Collection entries;

        field =kss.getClass().getEnclosingClass().getDeclaredField("entries");
        field.setAccessible(true);
        entries = ((HashMap) field.get(kss)).values();
    }catch(Exception e){
        e.printStackTrace();
    }
   }
}