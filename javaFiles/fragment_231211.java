public class ExtendedClass1 extends BaseClass{

    @Override
    public String toString() {
       return "ExtendedClass1 [total=" + total + ", number=" + number
            + ", list=" + list + ", isA=" + isA + ", x=" + x + "]";
    }

    public ExtendedClass1(){
        isA = "ExtendedClass1";
    }

    public Long total;
    public Long number;

}