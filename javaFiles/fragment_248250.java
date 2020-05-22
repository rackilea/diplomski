private void toZkString() {
    if (this == DEV) {
        return new Random().nextBoolean() ? "/zk/dc1" : "/zk/dc2";
    }
    return "/zk/" + name().toLowercase();
}

private static final String OUR_LOCATION_AS_ZK_STRING = ourlocation.toZkString();