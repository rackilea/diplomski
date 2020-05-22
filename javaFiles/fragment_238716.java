// MainActivity.java
public class MainActivity extends TTSActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void ttsReady() {
        speakText("Hello world");
    }
}