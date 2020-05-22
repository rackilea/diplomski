MainActivity.java
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
loadFragment(new HomeFragment());

    BottomNavigationView navigation = findViewById(R.id.navigation);
    navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
}

TranslatorFragment.java
public class TranslatorFragment extends Fragment {

public Button speakButton;

public TranslatorFragment(){
    //Empty Constructor
}

@Override
public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    return inflater.inflate(R.layout.translator_fragment, container, false);
}

public void onActivityCreated(Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
}

@Override
public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

     //Text to Speech
    tts = new TextToSpeech(getActivity(), this);

    speakButton = findViewById(R.id.speakButton);

    speechText = findViewById(R.id.speechText);

    speakButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            speakOut();
        }
    });
    // End
}
void speakOut(){
}