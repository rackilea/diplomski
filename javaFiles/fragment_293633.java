import java.util.*;

import org.apache.commons.net.ntp.TimeStamp;

public class NtpToUuid {

public static void main(String[] args) {
    TimeStamp t2 = TimeStamp.getCurrentTime();
    UUID uuid3 = com.datastax.driver.core.utils.UUIDs.startOf(t2.getTime());
    System.out.println("UUID3 : "+uuid3);
        }
}