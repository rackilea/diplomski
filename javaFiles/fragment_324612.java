InetAddress inetAddress = InetAddress.getByName(request.getRemoteAddr());
if (inetAddress instanceof Inet6Address) {
    // handle IPv6
} else {
    // handle IPv4
}