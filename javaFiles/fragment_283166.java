btn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        vibrator.vibrate(50);
        // you said you don't want to use the scale animation any more
        // txt.startAnimation(scale);
        if(nextSentenceId < sentences.length){
            // To get the String from the resource id,
            // you need a Context. Since every View has one:
            Context ctx = txt.getContext();
            String sentence = ctx.getResources().getString(sentences[nextSentenceId]);
            // Now pass the String (which is a kind of CharSequence)
            // to the TypeWriterTextView method
            txt.displayTextWithAnimation(sentence);
            ++nextSentenceId;
        }
    }
});