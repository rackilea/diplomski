public class SomeClass {
    private EnumSet<? extends EnumInterface> someEnum;
    public void setEnumType (int index) {
        switch (index) {
        case 1:
            someEnum = EnumSet.allOf(EnumOne.class);
            break;
        case 2:
            someEnum = EnumSet.allOf(EnumTwo.class);
            break;
        }
    }
}