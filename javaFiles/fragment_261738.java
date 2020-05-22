public interface IDefaultInterface {
public void m1();   
public static interface Impl extends IDefaultInterface{
    static aspect Implementation{
        public int IDefaultInterface.Impl.f1;
        public void IDefaultInterface.Impl.m1(){

        }

    }
}
}