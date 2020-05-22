final Foo immutable = FooFactory.create()
    .whereRangeConstraintsAre(100,300)
    .withColor(Color.BLUE)
    .withArea(234)
    .withInterspacing(12)
    .build();