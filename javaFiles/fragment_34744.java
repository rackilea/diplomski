...
then().
        root("find {it.type.name == '%s'}.status").
        body("id", withArgs("LPM"), is(1)).
        body("price", withArgs("LPM"), is(1.20f)).
        body("source", withArgs("LPM"), is(172)).
        body("id", withArgs("ST"), is(10));