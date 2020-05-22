public class Main {

        class FooQuery extends QueryResult<Foo> {}

        public static void main(String[] args) {
            Mapper mapper = new GsonMapper();
            String json = args[0];

            QueryResult<Foo> qr = mapper.fromJson(json, FooQuery.class);

            for (Foo foo : qr.getResults()) {
                System.out.println(foo.toString());
            }
    }