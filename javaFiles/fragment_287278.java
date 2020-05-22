public class Asd {

public static long[] IPToLong(String addr) {
    String[] addrArray = addr.split(":");//a IPv6 adress is of form 2607:f0d0:1002:0051:0000:0000:0000:0004
    long[] num = new long[addrArray.length];

    for (int i=0; i<addrArray.length; i++) {
        num[i] = Long.parseLong(addrArray[i], 16);
    }
    long long1 = num[0];
    for (int i=1;i<4;i++) {
        long1 = (long1<<16) + num[i];
    }
    long long2 = num[4];
    for (int i=5;i<8;i++) {
        long2 = (long2<<16) + num[i];
    }

    long[] longs = {long2, long1};
    return longs;
}


public static String longToIP(long[] ip) {
    String ipString = "";
    for (long crtLong : ip) {//for every long: it should be two of them

        for (int i=0; i<4; i++) {//we display in total 4 parts for every long
            ipString = Long.toHexString(crtLong & 0xFFFF) + ":" + ipString;
            crtLong = crtLong >> 16;
        }
    }
    return ipString;

}

static public void main(String[] args) {
    String ipString = "2607:f0d0:1002:0051:0000:0000:0000:0004";
    long[] asd = IPToLong(ipString);

    System.out.println(longToIP(asd));
}