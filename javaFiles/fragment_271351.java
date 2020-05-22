class Params {
    Integer type;
    @JsonProperty("chaincodeID")
    ChainCode chainCode;
    @JsonProperty("ctorMsg")
    private Message message;
    String secureContext;
}

class ChainCode{
    String path;
}

class Message {
    List<String> args;
}