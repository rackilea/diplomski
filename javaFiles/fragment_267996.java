...
@Override
protected void onCreate(Bundle savedInstanceState) {
    ...
    loseStarter3.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            ...
            final String[] colorString1 = new String[9];
            ...
            yellowButton.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                     if (word.getText().equals(colorString1[0]) ... ) {
                         score++;
                     }
                     Random colStr = new Random();
                     if (score<=9) {
                         final String[] colorString2 = new String[9];
                         ...
                     }
                     if (score>9) {
                         final String[] colorString3 = new String[36];
                         ...
                     }