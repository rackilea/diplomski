@XmlRootElement(name = "System")
    public class SystemDTO {

        private String id;
        private SourceDTO source;

        public String getId() {
            return id;
        }

        public SourceDTO getSource() {
            return source;
        }

        @XmlElement(name = "ID")
        public void setId(String id) {
            this.id = id;
        }

        @XmlElement(name = "Source")
        public void setSource(SourceDTO source) {
            this.source = source;
        }

    }