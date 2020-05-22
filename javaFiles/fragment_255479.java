public abstract class SuperClass {

    private Object field1;

    protected SuperClass(Object obj){
        // call the safe implementation
        setField1Safe(obj);
    }


    public void setField1(Object obj){
        // just delegates
        setField1Safe(obj);
    }

    private void setField1Safe(Object obj){
        // perform some check on obj and
        // then set field1 such that field1==obj
    }
}

public class SubClass extends SuperClass{
     public SubClass(Object obj){
         super(obj);
     }

     @Override
     public void setField1(Object obj){
         super.setField1(obj);
         // do some work that is necessary only when
         // field1 is set through SubClass.setField1()
     }
}