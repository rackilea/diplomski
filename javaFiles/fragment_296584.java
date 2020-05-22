public class SearchTextField extends TextField {    

        public SearchTextField(){
            super();
        }

        public void setInputHeight(int heightValue) {
            getInputEl().getStyle().setHeight(20, Unit.PX);
        }

        public String getInputHeight() {
            return getInputEl().getStyle().getHeight();
        }
    }