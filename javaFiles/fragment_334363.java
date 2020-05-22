public void drawRAnswers(int pst){
    int drawables = qmclist.get(pst).getAnswers().size();
    // create a radio group as container with direction
    RadioGroup l1 = new RadioGroup(this);
    l1.setOrientation(LinearLayout.VERTICAL);
    for (int i=0;i<drawables;i++){
        // create radio button, with id and text
        RadioButton rd = new RadioButton(this);
        rd.setId(i);
        rd.setText(current.getAnswers().get(i).getAns());
        // add radio button into group
        l1.addView(rd);
    }
    // finally, add radio group with buttons into parent layout  
    parentLinearLayout.addView(l1, parentLinearLayout.getChildCount());
}