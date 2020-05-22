from("direct:start")
        .choice()
            .when(header("product").isEqualTo(Product.Widget))
                .to("direct:widgets")
            .when(header("product").isEqualTo(Product.Fizz))
                .to("direct:fizzes")
            .otherwise()
                .to("direct:allOtherProducts");