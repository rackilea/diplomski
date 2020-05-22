@JsonDeserialize(builder = Checkout.Builder.class)
public class Checkout {
    private Long id;
    private User user;
    private Item item;

    // getters and setters

    public static class Builder {
        private Long id;
        private String username;
        private String serialNumber;

        @JsonProperty("id")
        public Builder setId(Long id) {
            this.id = id;
            return this;
        }

        @JsonProperty("user")
        public Builder setUsername(String username) {
            this.username = username;
            return this;
        }

        @JsonProperty("item")
        public Builder setSerialNumber(String serialNumber) {
            this.serialNumber = serialNumber;
            return this;
        }

        public Checkout build() {
            Checkout checkout = new Checkout();
            checkout.setId(id);
            checkout.setUser(/* lookup user by username */);
            checkout.setItem(/* lookup item by serialNumber */);
            return checkout;
        }
    }
}