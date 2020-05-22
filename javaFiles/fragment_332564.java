public class Build {
        private String name;
        private int images;
        private boolean selected;

        public Build(boolean selected, String name,int images) {
            this.images = images;
           this.selected=selected; 
           this.name = name;
        }

        public int getImages() {
            return images;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setSeleted(boolean selected){
            this.selected=selected;
        }

        public boolean isSelected(){
            return selected;
        } 
    }