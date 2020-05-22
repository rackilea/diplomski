public class FragmentInViewPager extends Fragment {

    private Callback mCallback;

    public interface Callback {
        void setViewPagerCurrentPage(int page);
    }

    @Override
    public void onAttach(Activity activity) {
        mCallback = (Callback) activity; 
        //NB: The above will throw ClassCastException if your Activity
        //Does not implement FragmentInViewPager.Callback
    }

    //To call it...
    int newPageNumber = 27;
    mCallback.setViewPagerCurrentPage(newPageNumber);