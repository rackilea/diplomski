import java.net.InetAddress;
import java.net.UnknownHostException;

import java.util.StringTokenizer;
import java.util.Vector;

import android.app.Activity;

/** This class checks that an IP exists in a specified subnet specified via netmask.

Supported netmask formats are:

1.1.1.1/255.255.255.255
1.1.1.1/32 (CIDR-style)

@todo: IPv6 support

*/
public class iprange extends Activity
{
/** Validate that IPAddress exists in NetMask address space */
public static boolean ValidateIP(String IPAddress, String NetMask) throws UnknownHostException, Exception
{
int ip, network, netmask, cidr, tokens = 0;

// convert IP to int
if (!validateInetAddress(IPAddress)) {
return false;
}
ip = toInt(InetAddress.getByName(IPAddress));

// split network/netmask
Vector<Object> nm = new Vector<Object>();
StringTokenizer nmt = new StringTokenizer(NetMask,"/");
while (nmt.hasMoreTokens()) {
nm.add(nmt.nextToken());
tokens++;
}
// we have an ip without netmask, assume /32
if (tokens==1) {
nm.add("32");
}

// network to int
if (!validateInetAddress(nm.get(0).toString())) {
return false;
}
network = toInt(InetAddress.getByName(nm.get(0).toString()));

// generate netmask int from cidr/network notations
if (nm.get(1).toString().length() < 3) {
cidr = Integer.parseInt( nm.get(1).toString() );
if (!validateCIDR(cidr, NetMask)) {
return false;
}
netmask = 0x80000000 >> (cidr - 1); // 1st bit is sticky
} else {
if (!validateInetAddress(nm.get(1).toString())) {
return false;
}
cidr = Integer.bitCount( toInt(InetAddress.getByName(nm.get(1).toString())) );
// if we get 255.127.1.0 it's considered like 255.255.0.0 ... add netmask validation?
}
if (cidr == 32) {
return ip==network;
}
netmask = 0x80000000 >> (cidr - 1);
return ((ip & netmask) == network);
}

/** Check cidr value in bounds */
private static boolean validateCIDR(int cidr, String NetMask) throws Exception
{
if (cidr<0 || cidr>32) {
throw new Exception("CIDR value out of bounds [0..32]: "+NetMask);
}
return true;
}

/** Validate the IP address doesn't have any out of bound values */
private static boolean validateInetAddress(String IPAddress) throws Exception
{
int i = 0;
StringTokenizer tokens = new StringTokenizer(IPAddress, ".");
while (tokens.hasMoreTokens()) {
String token = tokens.nextToken().toString();
if (!Integer.toString((Integer.parseInt(token)&0xff)).equals(token)) {
throw new Exception("Can't validate IP Address: "+IPAddress);
}
i++;
}
if (i>4) {
throw new Exception("IP Address has more than 4 parts: "+IPAddress);
}
return true;
}

/** Convert InetAddress to int */
private static int toInt(InetAddress inetAddress)
{
byte[] address = inetAddress.getAddress();
int net = 0;
for (int i=0; i<address.length; i++) {
net = (net<<8) | (address[i] & 0xff);
}
return net;
}
}