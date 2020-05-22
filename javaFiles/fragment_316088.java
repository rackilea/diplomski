public class SomeClass extends Fragment {
    ...
    private MyInterface listener;

    @Override
    void onCreate(...) {
        listener = (MyInterface) getActivity();
    }

    // your function to trigger a reusable 
    // function from Activity when user clicks on something
    public void onClick() {
        listener.triggerMainActivityFunction();
    }
    ...
}