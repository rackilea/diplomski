@RequiredArgsConstructor
public enum MyEnum {
    BAR1(Constants.BAR_VALUE),
    FOO("Foo"),
    BAR2(Constants.BAR_VALUE),
    ...,
    BARn(Constants.BAR_VALUE);



    @Getter
    private final String value;

    private static class Constants {
        public static final String BAR_VALUE = "BAR";
    }
}