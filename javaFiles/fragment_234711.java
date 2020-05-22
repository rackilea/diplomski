@FunctionalInterface // to guarantee the next rule
interface SessionExecutionBody {
    Object execute(); // has exactly one abstract method

    default void executeWithoutResult() {} // other methods should be default/static
}
...
sessionService.executeInLocalView(() -> { /* a body */ return ...; })