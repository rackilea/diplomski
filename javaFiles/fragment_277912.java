A a = new A();

when(a).doSomethingThatThrows();

then(caughtException())
        .isInstanceOf(IllegalStateException.class)
        .hasMessageContaining("is not allowed to add counterparties")
        .hasNoCause();