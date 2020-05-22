// put this somewhere else
    OptionView = new LinearLayout(this);
    OptionView.setOrientation(LinearLayout.VERTICAL);
    RelativeLayout.LayoutParams p = new RelativeLayout.LayoutParams(
            RelativeLayout.LayoutParams.WRAP_CONTENT,
            RelativeLayout.LayoutParams.WRAP_CONTENT);
    p.addRule(RelativeLayout.BELOW, img.getId());
    p.addRule(RelativeLayout.RIGHT_OF, questionNumber.getId());
    rel.addView(OptionView, p);


private void setOptions(int questionID2) {
    ArrayList<String> options = pustakDB.getOptions(questionID2);
    Log.e("optionsInAct", options.toString() + " size " + options.size());

    // this will remove all views from OptionView
    OptionView.removeAllViews();

    int i = 0;
    while (i < options.size()) {
        CheckBox c = new CheckBox(this);
        c.setText(options.get(i));
        c.setId(i);
        OptionView.addView(c);
        i++;
    }
}