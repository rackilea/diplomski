public abstract class A {  

    protected int[] array;

    public void someMethod() {
        int[] array = getArray();
        variable = array.length;
    }

    protected abstract int[] getArray();
}  

public class B extends A {  
    public int[] getArray() {
        if(array == null){
            array = new int[] { 1,2,3 };  
        }
        return array;
    }  
}