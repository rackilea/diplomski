interface I1 { }
interface I2 { }
final class C1 implements I1 { }
class C2 implements I2 { }

public class Test{
     public static void main(){
        C1 o1 = new C1();
        C2 o2 = new C2();
        Integer o3 = new Integer(4);

        I2 y = (I2)o3; //compiler complains here !!
        I2 x = (I2)o1; //compiler complains too
     }
}