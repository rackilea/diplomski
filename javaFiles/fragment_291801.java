String queryString = new URL("http://tesing12/testds/fdsa?communityUuid=45352-32452-52").getQuery();

String[] params = queryString.split("&");

String communityUuid = null;
for (String param : params) {
    if (param.startsWith("communityUuid=")) {
        communityUuid = param.substring(param.indexOf('=') + 1);
    }
}

if (communityUuid != null) {
    // do what you gotta do
}