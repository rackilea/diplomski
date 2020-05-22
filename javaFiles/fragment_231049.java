String ip = request.getRemoteAddr();
InetAddress inetAddress = InetAddress.getByName(ip);

if (inetAddress instanceof Inet6Address) {
    Inet6Address inet6Address = (Inet6Address) inetAddress;
    int scopeId = inet6Address.getScopeId();

    if (scopeId > 0) {
        ip = inet6Address.getHostName().replaceAll("%" + scopeId + "$", "");
    }
}