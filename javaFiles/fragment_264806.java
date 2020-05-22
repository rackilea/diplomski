@protocol MyProtocol
@optional
    -(void)method1;
    -(void)method2;
@required
    -(void)method3;
    -(void)method4;
    -(void)method5;
@end

interface IMyProtocol {
    void method3();
    void method4();
    void method5();
}

interface IMyProtocolMethod1 {
    void method1();
}

interface IMyProtocolMethod2 {
    void method2();
}

class MyProtocolImplWithMethod2 implements IMyProtocol, IMyProtocolMethod2 {
    public void method2() {
    }
    public void method3() {
    }
    public void method4() {
    }
    public void method5() {
    }
}