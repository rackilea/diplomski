userList.stream()
        .map(user -> {
               counter.getAndIncrement();
               return new Foo(getName(user), getId(user));
            })
        .forEach(fooList::add);