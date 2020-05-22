// Outer Scope of Activity: SCOPE_MAIN
...
@Override
protected void onCreate(Bundle savedInstanceState) {
    // Local Scope of onCreate Method: SCOPE_OUTER_MLOCAL
    ...
    loseStarter3.setOnClickListener(new View.OnClickListener() {
        // Outer Closure
        // anonymous class/closure with closures Scope: SCOPE_OUTER_CLOSURE
        @Override
        public void onClick(View v) {
            // Local Scope of onClick Method: SCOPE_OUTER_CLOSURE_MLOCAL
            ...
            final String[] colorString = new String[9];
            ...
            yellowButton.setOnClickListener(new View.OnClickListener() {
                 // Inner Closure
                 // Scope: SCOPE_INNER_CLOSURE
                 @Override
                 public void onClick(View v) {
                     // Local Scope: SCOPE_INNER_CLOSURE_MLOCAL
                     // NOTICE that colorString is the USE of colorString DECLARED in SCOPE_OUTER_CLOSURE_MLOCAL
                     if (word.getText().equals(colorString[0]) ... ) {
                         score++;
                     }
                     Random colStr = new Random();
                     if (score<=9) {
                         // Scope introduced with declaration: SCOPE_INNER_CLOSURE_MLOCAL_SUB1
                         final String[] colorString = new String[9];
                         ...
                         // This actually select the string from SCOPE_INNER_CLOSURE_MLOCAL_SUB1
                         word.setText(colorString[decider]);
                         // End of SCOPE_INNER_CLOSURE_MLOCAL_SUB1
                         // the here declared colorString does not exist anymore after this is executed
                     }
                     if (score>9) {
                         // Scope introduced with declaration: SCOPE_INNER_CLOSURE_MLOCAL_SUB2
                         final String[] colorString = new String[36];
                         ...
                         word.setText(colorString[decider]);
                     }