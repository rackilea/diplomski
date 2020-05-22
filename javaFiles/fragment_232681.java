@XmlRootElement(name = "Source")
    class SourceDTO {
        private String name = null;

        public String getName() {
            return name;
        }

        @XmlElement(name = "Name")
        public void setName(String name) {
            this.name = name;
        }

    }