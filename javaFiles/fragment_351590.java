public class LombokAndProperties {

    public static void main(String[] args) {
        Model model = new Model();

        model.getStringProperty(); // <- return the String that is stringProperty.get()
        model.stringProperty(); // <- return the StringProperty itself

    }

    private static class Model{

        @Accessors(fluent = true)
        @Getter
        private StringProperty stringProperty;

        public String getStringProperty(){
            return stringProperty.get();
        }
    }

}