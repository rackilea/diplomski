protected Entities entities;
@JsonIgnoreProperties(ignoreUnknown = true)
protected class Entities {
    public Entities() {}
    @JsonDeserialize(contentAs=Tag.class)
    protected List<Tag> tags;

    @JsonIgnoreProperties(ignoreUnknown = true)
    protected class Tag {
        public Tag() {}

        protected String text;

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    };

    public Tags getTags() {
        return tags;
    }
    public void setTags(Tags tags) {
        this.tags = tags;
    }
};