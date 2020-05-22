import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import net.sourceforge.jpcap.capture.CaptureDeviceLookupException;
import net.sourceforge.jpcap.capture.PacketCapture;

public class JpcapInterfaceInfo {


    /**
     * Get a list of interface information for all devices returned by jpcap.
     * @param capture An instance of PacketCapture to use for getting network address and mask info. If null,
     *                a new instance will be created.
     * @return List of information.
     * @throws CaptureDeviceLookupException
     */
    public static List<InterfaceInfo> listInterfaces (PacketCapture capture) throws CaptureDeviceLookupException {

        if (capture == null)
            capture = new PacketCapture();

        List<InterfaceInfo> infos = new ArrayList<InterfaceInfo>();
        for (String device : PacketCapture.lookupDevices())
            infos.add(getInterfaceInfo(capture, device));

        return infos;

    }


    /**
     * Get a list of interface information for all devices returned by jpcap.
     * @return List of information.
     * @throws CaptureDeviceLookupException
     */
    public static List<InterfaceInfo> listInterfaces () throws CaptureDeviceLookupException {
        return listInterfaces(null);
    }




    /**
     * Utility to check if an interface address matches a jpcap network address and mask.
     * @param address An InetAddress to check.
     * @param jpcapAddr Network address.
     * @param jpcapMask Network mask.
     * @return True if address is an IPv4 address on the network given by jpcapAddr/jpcapMask,
     *         false otherwise.
     */
    private static boolean networkMatches (InetAddress address, int jpcapAddr, int jpcapMask) {

        if (!(address instanceof Inet4Address))
            return false;

        byte[] address4 = address.getAddress();
        if (address4.length != 4)
            return false;

        int addr = ByteBuffer.wrap(address4).order(ByteOrder.LITTLE_ENDIAN).getInt();        
        return ((addr & jpcapMask) == jpcapAddr);

    }


    /**
     * Get an InterfaceInfo that corresponds to the given jpcap device string. The interface must be
     * up in order to query info about it; if it is not then the NetworkInterface in the returned
     * InterfaceInfo will be null.
     * @param capture A PacketCapture instance used to get network address and mask info.
     * @param jpcapDeviceString String from PacketCapture.lookupDevices().
     * @return InterfaceInfo.
     */
    public static InterfaceInfo getInterfaceInfo (PacketCapture capture, String jpcapDeviceString) {

        InterfaceInfo info = null;
        String deviceName = jpcapDeviceString.replaceAll("\n.*", "").trim();

        try {

            int netAddress = capture.getNetwork(deviceName);
            int netMask = capture.getNetmask(deviceName);

            // go through all addresses of all interfaces and try to find a match.

            Enumeration<NetworkInterface> e = NetworkInterface.getNetworkInterfaces();
            while (e.hasMoreElements() && info == null) {
                NetworkInterface iface = e.nextElement();
                Enumeration<InetAddress> ae = iface.getInetAddresses();
                while (ae.hasMoreElements() && info == null) {
                    if (networkMatches(ae.nextElement(), netAddress, netMask))
                        info = new InterfaceInfo(iface, deviceName);
                }
            }

        } catch (Exception x) {

            System.err.println("While querying info for " + deviceName + ":");
            x.printStackTrace(System.err);

        }

        if (info == null)
            info = new InterfaceInfo(null, deviceName);

        return info;

    }


    /**
     * Information about a network interface for jpcap, which is basically just a NetworkInterface
     * with details, and the jpcap device name for use with PacketCapture.
     */
    public static class InterfaceInfo {

        private final NetworkInterface iface;
        private final String deviceName;

        InterfaceInfo (NetworkInterface iface, String deviceName) {
            this.iface = iface;
            this.deviceName = deviceName;
        }

        /**
         * Get NetworkInterface for this interface.
         * @return May return null if no matching NetworkInterface was found.
         */
        public final NetworkInterface getIface () {
            return iface;
        }

        /**
         * Get jpcap device name for this interface. This can be passed to PacketCapture.open().
         * @return Device name for interface.
         */
        public final String getDeviceName () {
            return deviceName;
        }

        @Override public final String toString () {
            return deviceName + " : " + iface;
        }

    }


}