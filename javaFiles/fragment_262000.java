NetworkInterface ni;
try (MulticastSocket s = new MulticastSocket()) {
    ni = s.getNetworkInterface();
}

MembershipKey key = channel.group(join, ni);