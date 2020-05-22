import java.io.IOException;

public interface IO {

    void write(DataOutputStream out) throws IOException;

    void read(DataInputStream in) throws IOException;

}