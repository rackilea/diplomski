public class ExtendedClass2 extends BaseClass{

    @Override
    public String toString() {
      return "ExtendedClass2 [total=" + total + ", list=" + list + ", isA="
            + isA + ", x=" + x + "]";
    }

    public ExtendedClass2(){
        isA = "ExtendedClass2";
    }

    public Long total;

}