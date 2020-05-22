userList.stream()
        .map(user -> new Foo(getName(user), getId(user)))
        .forEach(foo -> {
            fooList.add(foo);
            counter.getAndIncrement();
        });