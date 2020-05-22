public class Shop {
    private enum Status {
        OPENED("opened"),CLOSED("closed");

        private Status(String label) {
            this.label = label;
        }

        public String label;

        public String getLabel() {
            return label;
        }
    } 
}