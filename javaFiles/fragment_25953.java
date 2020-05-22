//this is ultimately tested by the assertThrownBy, let's keep it that way:
when(service1.doSomething()).thenReturn(Mono.error(new IllegalStateException("Something bad happened")));

//this will be used to ensure the `service2` Mono is never actually used: 
PublisherProbe<SomeResponse> service2Probe = PublisherProbe.of(Mono.just(new SomeResponse()));
//we still need the mock to return a Mono version of our probe
when(service2.doSomething()).thenReturn(service2Probe.mono());

assertThatThrownBy(() -> testedService.doSomething().block())
            .isExactlyInstanceOf(IllegalStateException.class);

//service2 might have returned a lazy Mono, but it was never actually used:
probe.assertWasNotSubscribed();