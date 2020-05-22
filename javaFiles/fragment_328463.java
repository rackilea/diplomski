import java.util.List;

import net.sourceforge.jpcap.capture.PacketCapture;

public class JpcapInterfaceInfoTest {

    public static void main (String[] args) throws Exception {

        // Info can be queried from jpcap device list.
        List<JpcapInterfaceInfo.InterfaceInfo> infos = JpcapInterfaceInfo.listInterfaces();

        // Info can be displayed.
        for (JpcapInterfaceInfo.InterfaceInfo info : infos)
            System.out.println(info);

        // Device names from InterfaceInfo can be passed directly to jpcap:
        JpcapInterfaceInfo.InterfaceInfo selected = infos.get(0);
        PacketCapture capture = new PacketCapture();
        capture.open(selected.getDeviceName(), true);

    }

}