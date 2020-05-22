@JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "messageId")
    public class Message implements Serializable {

        private UUID messageId;

        @JsonIdentityReference(alwaysAsId = true)
        private User messageCreatorUser;

        // -- other fields and such --

        public User getMessageCreatorUser() {
            return messageCreatorUser;
        }

        public void setMessageCreatorUser(User messageCreatorUser) {
            this.messageCreatorUser = messageCreatorUser;
        }

        @JsonProperty("messageCreatorUser")
        public void setMessageCreatorUser(String userId) {
            this.messageCreatorUser = new User(userId);
        }