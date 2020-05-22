import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class TestSer {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        SerializableSingleton singleton = SerializableSingleton.INSTANCE;

        String data = "¬í\0\5sr\0\25SerializableSingleton\0\0\0\0\0\0\0\1\2\0\1L\0\1at\0\10"
            + "LSneaky;xpsr\0\6SneakyOÎæJ&r\234©\2\0\1L\0\1rt\0\27LSerializableSingleton;"
            + "xpq\0~\0\2";
        try(ByteArrayInputStream baos=new ByteArrayInputStream(data.getBytes("iso-8859-1"));
            ObjectInputStream oos = new ObjectInputStream(baos)) {
            SerializableSingleton official = (SerializableSingleton)oos.readObject();

            System.out.println(official+"\t"+(official == singleton));
            Object inofficial = Sneaky.instance.r;
            System.out.println(inofficial+"\t"+(inofficial == singleton));
        }
    }
}
class Sneaky implements Serializable {
    static Sneaky instance;

    SerializableSingleton r;

    Sneaky(SerializableSingleton s) {
        r = s;
    }

    private Object readResolve() {
        return instance = this;
    }
}