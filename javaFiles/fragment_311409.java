int ip = ip2int(socket.getInetAddress().getHostName());

// iterate over black list, split item into subnet and bits
String line = "192.168.1.0/24";
String[] a = line.split("/");
int subnet = ip2int(a[0]);
// make a mask
int bits = a.length == 1 ? 0 : Integer.parseInt(a[1]);
int mask = 0xFFFFFFFF << 32 - bits;
// mask client ip and compare
if ((ip & mask) == subnet) {
// match
}