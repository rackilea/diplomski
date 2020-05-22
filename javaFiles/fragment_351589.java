public class LombokAndProperties {

    public static void main(String[] args) {
        Model model = new Model();

        model.getStringProperty(); // <- return the String that is stringProperty.getStringProperty()
        model.stringProperty(); // <- return the StringProperty itself

    }



    private static class Model{

        private interface DelegateExample {
            String getStringProperty();
        }

        @Accessors(fluent = true)
        @Getter
        @Delegate(types = DelegateExample.class)
        private StringProperty stringProperty = new StringProperty();

    }

    private static class StringProperty {
        String property = "p";

        public String getStringProperty(){
            return property;
        }
    }
}