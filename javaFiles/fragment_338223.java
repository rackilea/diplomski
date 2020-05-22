public abstract class BaseClass {
    public abstract int getAge();
}
public class ChildOne extends BaseClass {
    @Override public int getAge(){
        return AgeEnum.ChildAge.CHILD_ONE.getValue();
    }
}
public class ChildTwo extends BaseClass {
    @Override public int getAge(){
        return AgeEnum.ChildAge.CHILD_TWO.getValue();
    }
}