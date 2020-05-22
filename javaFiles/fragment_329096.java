class Event {

    private Channel channel;

    private String channelStr;

    @JsonSetter("channel")
    public void setChannelInternal(JsonNode channelInternal) {
        if (channelInternal != null) {
            if (channelInternal.isTextual()) {
                channelStr = channelInternal.asText();
            } else if (channelInternal.isObject()) {
                int id = channelInternal.get("id").intValue();
                String name = channelInternal.get("name").asText();
                channel = new Channel(id, name);
            }
        }
    }

    public Channel getChannel() {
        return channel;
    }

    public String getChannelStr() {
        return channelStr;
    }
}