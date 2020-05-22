public class Tab1 extends Fragment {

private EditText editText;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.chatsview,container,false);
        editText = v.findViewById(R.id.YOUR_EDIT_TEXT_ID);
        return v;
    }
}