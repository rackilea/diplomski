public static class PlaceholderFragment extends Fragment {

    public PlaceholderFragment() {
    }
    EditText editText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        editText = (EditText) rootView.findViewById(R.id.edit_message);
        return rootView;
    } 

/** Called when the user clicks the Send button */
public void sendMessage(View view) {
    Intent intent = new Intent(getActivity(), DisplayMessageActivity.class);        
    String message = editText.getText().toString();
    intent.putExtra(EXTRA_MESSAGE, message);
    startActivity(intent);
}