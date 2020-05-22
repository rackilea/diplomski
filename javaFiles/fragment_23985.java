public class ModelExample {

        String title;
        String from;
        String to;
        String at;

        public ModelExample(String title, String from, String to, String at) {
            this.title = title;
            this.from = from;
            this.to = to;
            this.at = at;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getFrom() {
            return from;
        }
        public void setFrom(String from) {
            this.from = from;
        }
        public String getTo() {
            return to;
        }
        public void setTo(String to) {
            this.to = to;
        }
        public String getAt() {
            return at;
        }
        public void setAt(String at) {
            this.at = at;
        }
}