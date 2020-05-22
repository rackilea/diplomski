public class BaseClass{

    @Override
    public String toString() {
        return "BaseClass [list=" + list + ", isA=" + isA + ", x=" + x + "]";
    }

    public ArrayList<BaseClass> list = new ArrayList<BaseClass>();

    protected String isA="BaseClass"; 
    public int x;

 }