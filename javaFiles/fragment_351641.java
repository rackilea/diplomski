public class BaseClass
{
    private int id;

    //.
    //.
    //.

    public static class CmpID implements Comparator<BaseClass>
    {
        @Override
        public int compare(BaseClass a, BaseClass b) {
            //Could be implemented null safe
            return a.id - b.id;
        }
    }
}