private String getCurrentClientIpAddress() {
    String currentThreadName = Thread.currentThread().getName();
    System.out.println("Threadname: "+currentThreadName);
    int begin = currentThreadName.indexOf('[') +1;
    int end = currentThreadName.indexOf(']')-1;
    String remoteClient = currentThreadName.substring(begin, end);
    return remoteClient;
}