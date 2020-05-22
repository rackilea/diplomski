@GroupSequence({YourClass.class, Second.class, Third.class})
public class YourClass {
    @NotNull
    @Pattern(regexp="(\\-?\\d)+", groups=Second.class)
    @Min(value=1, groups=Third.class)
    String myField;
}