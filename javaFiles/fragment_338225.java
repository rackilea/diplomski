public abstract class BaseClass {
    @Retention(RetentionPolicy.RUNTIME) @Target(ElementType.TYPE)
    @interface Age { AgeEnum.ChildAge value(); }

    public int getAge() {
        return getClass().getAnnotation(Age.class).value().getValue();
    }
}

@Age(AgeEnum.ChildAge.CHILD_ONE)
public class ChildOne extends BaseClass {
}

@Age(AgeEnum.ChildAge.CHILD_TWO)
public class ChildTwo extends BaseClass {
}