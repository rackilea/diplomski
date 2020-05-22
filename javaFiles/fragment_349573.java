public class UserInputSet
{
    private List<Double> mDataCost = new ArrayList(); 
    private static UserInputSet mUserInputSet = new UserInputSet(); //Object as static
    private UserInputSet()
    {
        // Empty Constructor declared as private so this class can nt be create object outside class.
    }

    public List<Double> getDataCost()
    {
        return mDataCost;
    }

    private void setData(List<Double> list)
    {
        if(list != null)
        {
            mList.clear();
            mList.addAll(list);
        }
    }

    public static UserInputSet getThis()
    {
        return mUserInputSet;
    }
}