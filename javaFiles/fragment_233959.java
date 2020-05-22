public abstract class A{
    ...

    public abstract void OnEvent();
}

public class B{
    A objA = new A() {
        public void OnClick() {
            //OnClick implementation
        }
    };
    ...
}