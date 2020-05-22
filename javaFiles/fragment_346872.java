public class MyClass { ... }

public class TenPlusMyClass extends MyClass implements TenPlusInterface {}

public class MyClassFactory {
     MyClass getMyClass(int sdkVersion) { 
        return sdkVersion > 10 ? new TenPlusMyClass() : new MyClass();
     }
}