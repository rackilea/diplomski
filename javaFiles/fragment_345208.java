public class MyRouteBuilder extends RouteBuilder {

            private String another;
            private String letter;

            public MyRouteBuilder(CamelContext context,String another, String letter) {
                super(context);
                this.another=another;
                this.letter=letter;
            }

            @Override
            public void configure() throws Exception {
                super.configure();
                from("restlet:/"+another+"?restletMethods=GET")
                .to("first:run_"+letter)
                .to("second:jump_"+letter)
                .to("third:fly_"+letter);
            }
    }