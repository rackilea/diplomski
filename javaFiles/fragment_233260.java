public class CompareBoth {

    public void lambda() {
        Function<String,String> fct = s -> s;
        fct.apply("a");
    }


    public void anonymousClass() {
        Function<String,String> fct = new Function<String, String>() {

            @Override
            public String apply(String t) {
                return t;
            }

        };
        fct.apply("a");
    }
}