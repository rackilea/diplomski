import org.apache.commons.net.ntp.NTPUDPClient;
import org.apache.commons.net.ntp.TimeInfo;


public long getRemoteNTPTime() {
    NTPUDPClient client = new NTPUDPClient();
    // We want to timeout if a response takes longer than 5 seconds
    client.setDefaultTimeout(5000);
    //NTP server list
    for (String host : hosts) {

        try {
            InetAddress hostAddr = InetAddress.getByName(host);
            TimeInfo info = client.getTime(hostAddr);
            return info.getMessage().getTransmitTimeStamp().getTime();

        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    client.close();

    return null;

}