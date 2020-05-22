URL url = new URL("protocol://user:password@host:port/path/document?arg1=val1&arg2=val2#part");
url.getProtocol();
url.getUserInfo();
url.getAuthority();
url.getHost();
url.getPort();
url.getPath(); // document part is contained within the path field
url.getQuery();
url.getRef(); // gets #part