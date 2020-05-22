public class MenuFragment extends Fragment {

    public interface Interface1{
        public void b();
    }

    public interface Interface2 extends Interface1{
        public void a();
    }

    public interface Interface3 extends Interface1{
        public void c();
    }

    Interface2 mCallback;

    @Override
    public void onAttach(Activity activity){
        super.onAttach(activity);
        try {
            mCallback = (Interface2 ) activity;
        } 
        catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()+ " must implement ItemselectedCallback");
        }
    }

    @Override
    public void onDetach(){
        mCallback = null;
        super.onDetach();
    }

    //somewhere 
    mCallback.a();

}