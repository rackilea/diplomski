public final class Messages {


    private Messages(){}

    public static MessageBuilder standard() {
        return new MessageBuilder();
    }



    public final static class MessageBuilder {

        /*@JsonProperty("mid")
        String id;

        String userId;
        String botId;
        String conversationId;

        @JsonProperty("text")
        String text;*/


        @SuppressWarnings("serial")
        private Map<String, String> state = new HashMap<String, String>() {};

        @JsonProperty("mid")
        public MessageBuilder withId(String id) {
            state.put("id", id);
            //this.id = id;
            return this;
        }

        //@JsonProperty("userId")
        public MessageBuilder withUserId(String userId) {
            state.put("userId", userId);
            //this.userId = userId;
            return this;
        }

        //@JsonProperty("botId")
        public MessageBuilder withBotId(String botId) {
            state.put("botId", botId);
            //this.botId = botId;
            return this;
        }

        //@JsonProperty("conversationId")
        public MessageBuilder withConversationId(String conversationId) {
            state.put("conversationId", conversationId);
            //this.conversationId = conversationId;
            return this;
        }

        @JsonProperty("text")
        public MessageBuilder withText(String text) {
            state.put("text", text);
            //this.text = text;
            return this;
        }

        public Message build() {
            Message result = null;
            result = new Message(state.get("id"), 
                                 state.get("userId"), 
                                 state.get("botId"), 
                                 state.get("conversationId"), 
                                 state.get("text"));
            //result = new Message(id, userId, botId, conversationId, text);
            return result;
        }

    }

    public final static class PushMessageBuilder{

    }
}