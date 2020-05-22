for (int i=0;i<=255;i++) {
    String destination = "74.125.24." + i;
    InetAddress address = InetAddress.getByName(destination);

    if (address == null) // Or any exception.
         continue;

    String resolvedHost = address.getHostName();

    System.out.println("Translated " + destination + " to host name " + resolvedHost);
}