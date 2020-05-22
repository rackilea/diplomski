public class TopStoriesFragment extends BaseFragment {

    ...


    @Override
    public boolean onBackPressed()
    {
       //if you return false, then it is because you have not consumed 
       //the event, but if it          returns true, which is consumed by this event.
        return false;
    }
}