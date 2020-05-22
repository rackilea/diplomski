package codesounding;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/*
  Every instruction type triggers an UDP message, each on different ports:
            Variable declaration:   7001
            Start block ({):        7002
            End block (}):          7003
            break:                  7004
            continue:               7005
            do:                     7006
            for:                    7007
            if:                     7008
            return:                 7009
            throw:                  7010
            while:                  7011
 */
public class UDPProcessor extends SilentProcessor {
    private static final String TARGET = "target"; //target host name
    private final DatagramPacket packetVar;
    private final DatagramPacket packetStart;
    private final DatagramPacket packetEnd;
    private final DatagramPacket packetBreak;
    private final DatagramPacket packetContinue;
    private final DatagramPacket packetDo;
    private final DatagramPacket packetFor;
    private final DatagramPacket packetIf;
    private final DatagramPacket packetReturn;
    private final DatagramPacket packetThrow;
    private final DatagramPacket packetWhile;
    final DatagramSocket socket; 
    final byte[] signal = "1;\n".getBytes(); //this message will trigger both PureData and MaxMSP UDP receivers; see the example patches

    public UDPProcessor() {
        try {
            String target = "127.0.0.1";
            if (System.getProperty(TARGET) != null  && !System.getProperty(TARGET).equals("")) {
                target = System.getProperty(TARGET);
            }
            System.out.println("Sending to "+target+"...");
            socket = new DatagramSocket();
            InetAddress address = InetAddress.getByName(target);

            packetVar = new DatagramPacket(signal, signal.length, address, 7001);
            packetStart = new DatagramPacket(signal, signal.length, address, 7002);
            packetEnd = new DatagramPacket(signal, signal.length, address, 7003);
            packetBreak = new DatagramPacket(signal, signal.length, address, 7004);
            packetContinue = new DatagramPacket(signal, signal.length, address, 7005);
            packetDo = new DatagramPacket(signal, signal.length, address, 7006);
            packetFor = new DatagramPacket(signal, signal.length, address, 7007);
            packetIf = new DatagramPacket(signal, signal.length, address, 7008);
            packetReturn = new DatagramPacket(signal, signal.length, address, 7009);
            packetThrow = new DatagramPacket(signal, signal.length, address, 7010);
            packetWhile = new DatagramPacket(signal, signal.length, address, 7011);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private synchronized void send(DatagramPacket packet) {
        try {
            socket.send(packet);
        } catch (IOException e) {
            e.printStackTrace();
            //skipping 
        }
    }

    public void getVarDeclaration() {
        send(packetVar);
    }

    public void getStartBlock() {
        send(packetStart);
    }

    public void getEndBlock() {
        send(packetEnd);
    }

    public void getIfStatement() {
        send(packetIf);
    }

    public void getForStatement() {
        send(packetFor);
    }

    public void getDoStatement() {
        send(packetDo);
    }

    public void getWhileStatement() {
        send(packetWhile);
    }

    public void getReturnStatement() {
        send(packetReturn);
    }

    public void getBreakStatement() {
        send(packetBreak);
    }

    public void getContinueStatement() {
        send(packetContinue);
    }

    public void getThrowStatement() {
        send(packetThrow);
    }

}