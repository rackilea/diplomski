import java.util.ArrayList;
import java.util.Collection;

public class TestClass {

    public static int PARENTTYPE=0;
    public static int CHILDTYPE=1;

    ArrayList<ParentClass> parentHolder=new ArrayList<ParentClass>();
    ArrayList<ChildClass> childHolder=new ArrayList<ChildClass>();

    public TestClass(){
        parentHolder.add(new ParentClass());
        childHolder.add(new ChildClass());
    }

    public ArrayList<? extends ParentClass> getHolder(int type){
        if (type==PARENTTYPE){
            return parentHolder;
        }else if (type==CHILDTYPE){
            return childHolder; //<-- no longer incompatible types
        }else{
            throw new RuntimeException("Not a valid type");
        }
    }

    public static void main(String args[]){
        TestClass test=new TestClass();

        ArrayList<? extends ParentClass> col1=test.getHolder(PARENTTYPE);
        ArrayList<? extends ParentClass> col2=test.getHolder(CHILDTYPE);

        ParentClass childCastToParent=col2.get(0);

    }
}