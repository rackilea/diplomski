public class YourFragment extends Fragment{
    private Button nextButton;
    private EditText text1;
    private EditText text2;
    protected ActivityCallback callback;

    ...

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        callback = (ActivityCallback) context;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ...
        nextButton = (Button) findViewById(R.id.next_button);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callback.sendData(text1.getText().toString(),text2.getText().toString());
            }
        });
    }
}