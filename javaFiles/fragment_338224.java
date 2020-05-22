public abstract class BaseClass {
    public int getAge() {
        return childAge().getValue();
    }
    abstract AgeEnum.ChildAge childAge();
}
public class ChildOne extends BaseClass {
    @Override AgeEnum.ChildAge childAge() {
        return AgeEnum.ChildAge.CHILD_ONE;
    }
}
public class ChildTwo extends BaseClass {
    @Override AgeEnum.ChildAge childAge() {
        return AgeEnum.ChildAge.CHILD_TWO;
    }
}