public class MyFragment extends Fragment {

    public static Fragment newInstance(...) {
        MyFragment f = new MyFragment();
        // Since fragments require that you have a
        // public constructor with zero arguments, then
        // we use this pattern to initialize the fragment.
        ...
        return f;
    }
    ...
}