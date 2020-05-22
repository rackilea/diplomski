class Event {

    @JsonProperty("channel")
    private JsonNode channelInternal;

    private Channel channel;

    private String channelStr;

    /**
     * Custom getter with channel parsing
     * @return channel
     */
    public Channel getChannel() {
        if (channel == null && channelInternal != null) {
            if (channelInternal.isObject()) {
                int id = channelInternal.get("id").intValue();
                String name = channelInternal.get("name").asText();
                channel = new Channel(id, name);
            }
        }
        return channel;
    }

    /**
     * Custom getter with channel string parsing
     * @return channel string
     */
    public String getChannelStr() {
        if (channelStr == null && channelInternal != null) {
            if (channelInternal.isTextual()) {
                channelStr = channelInternal.asText();
            }
        }
        return channelStr;
    }
}