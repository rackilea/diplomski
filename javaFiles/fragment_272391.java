Person p3 =
    Builder.update(p)
    .withAddress(
        Builder.update(p.address())
       .withCity("Berlin")
       .build()
    )
    .build();