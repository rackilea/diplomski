Set<String> localhostAddresses = new HashSet<String>();
localhostAddresses.add(InetAddress.getLocalHost().getHostAddress());
for (InetAddress address : InetAddress.getAllByName("localhost")) {
    localhostAddresses.add(address.getHostAddress());
}

if (localhostAddresses.contains(request.getRemoteAddr())) {
    // handle localhost
} else {
    // handle non-localhost
}