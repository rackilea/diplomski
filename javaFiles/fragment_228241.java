@InitBinder
public void initBinder(WebDataBinder dataBinder) {
    dataBinder.registerCustomEditor(MyMessage.class, new PropertyEditorSupport() {
        Object value;
        @Override
        public Object getValue() {
            return value;
        }

        @Override
        public void setAsText(String text) throws IllegalArgumentException {
            value = new Gson().fromJson((String) text, MyMessage.class);
        }
    });
}