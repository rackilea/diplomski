StepVerifier.create(dataFlux)
        .thenConsumeWhile(v -> {
            assertThat(v).equalsTo(expected);
            return true;
        })
        .verifyComplete();