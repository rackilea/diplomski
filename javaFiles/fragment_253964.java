public abstract class TypeBase {

}

public class TypeOne extends TypeBase {
    public TypeOne(String val1, String val2) {
        // TODO Auto-generated constructor stub
    }
}

public class TypeTwo extends TypeBase {
    public TypeTwo(String val1, String val2, int val3, boolean val4) {
        // TODO Auto-generated constructor stub
    }
}

public <T extends TypeBase> List<T> getReusable(int method) {
    List<T> mResuableList = new ArrayList<T>();
    switch (method) {
    case 1:
        mResuableList.add((T) new TypeOne("TypeOne", "TypeOneID"));
        break;
    case 2:
        mResuableList.add((T) new TypeTwo("TypeTwo", "TypeTwoID", 1234, true));
        break;
    default:
        break;
    }
    return mResuableList;
}

public class UsingClass{
    public void callReusable(){
        List<TypeOne> lstOne = getReusable(1);
        List<TypeTwo> lstTwo = getReusable(2);
    }
}