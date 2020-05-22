public class MyBean
{
    private ArrayList myList;
    private PersistentFacesState state;

    public MyBean
    {
        state = PersistentFacesState.getInstance();
        myList = new ArrayList();
        new Thread(new RunService()).start();
    }

    public class RunService implements Runnable
    {
        public void run()
        {
            try
            {
                list = WebServices.getList();
                state.executeAndRender(); //Need to do this to update view

            }
            catch(Exception e)
            {

            }
        }

    }
}