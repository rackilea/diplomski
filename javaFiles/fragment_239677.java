import gnu.io.NRSerialPort;
import gnu.io.UnsupportedCommOperationException;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.Arrays;

public class PulseOximeter {
    public static void main( String[] argv ) throws IOException, UnsupportedCommOperationException {
        NRSerialPort serial = new NRSerialPort("/dev/rfcomm0", 115200);
        serial.connect();

        DataInputStream ins = new DataInputStream(serial.getInputStream());

        // read the first 10000 bytes a byte at a time
        for( int i = 0; i < 10000; i++ ) {
            int b = ins.read();
            if( b == -1 ) {
                System.out.println( "got EOF - going to keep trying" );
                continue;
            }
        }

        serial.disconnect();
    }
}