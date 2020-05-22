public class TextC extends MainActivity {

 @Override
 protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    //changeText(); no need to call these methods bcz its already called in parent onCreate()
    //changeText2();
};

    @Override
    public void changeText() {
        super.changeText();
        final String[] revertText = {"H2O", "What elements does water consist of?"};

        final TextView textChange = findViewById(R.id.flashcard1);
        Button change = findViewById(R.id.answer1);

        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int random = (int) (Math.random() * revertText.length);
                textChange.setText(revertText[random]);
            }
        });
    }

    public void changeText2() {
        super.changeText2();
        final String[] revertText = {"2,200° F", "How hot does lava get?"};

        final TextView textChange = findViewById(R.id.flashcard2);
        Button change = findViewById(R.id.answer2);

        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int random = (int) (Math.random() * revertText.length);
                textChange.setText(revertText[random]);
            }
        });
    }
}