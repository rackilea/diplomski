public AbstractFoobar fooGenerator(AbstractFoobar foobar) {
    return foo(foobar, /* something here, involving AbstractFoobar and casts */::new);
}

// Call site
Bar foobar = (Bar) foo(bar);