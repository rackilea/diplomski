class One {
    @Id String id;
    String value;
    // ... 
}

class Two extends One {
    // ...
}

One probe = new One();
probe.value = "firefight";

Example<One> example = Example.of(probe, ExampleMatcher.matchingAny());