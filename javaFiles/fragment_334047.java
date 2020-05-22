public enum ExampleEnum {
    FOO(InitParams.builder()
                  .setAge(20)
                  .build()),
    ...

    private ExampleEnum(InitParams params) {
        ...
    }

    private static class InitParams {
        ...
    }
}