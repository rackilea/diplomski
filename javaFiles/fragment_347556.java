private String subjectSelected = "";
public void onRadioButtonClicked(View view) {
    RadioButton radioButton = (RadioButton) view;

    switch(view.getId()) {
        case R.id.math:
            subjectSelected = radioButton.getText().toString();
            break;
        case R.id.physic:
            subjectSelected = radioButton.getText().toString();
            break;
        case R.id.problems_solving:
            if (subjectSelected.equals("math")) {
                showFirstWord ("math problem resolution");
            } else if (subjectSelected.equals("physic")) {
                showThirdWord("physic problem solving");
            }
            break;
        case R.id.theories:
            if (subjectSelected.equals("math")) {
                showSecondWord("math theories");
            } else if (subjectSelected.equals("physic")) {
                showFourthWord("physic theories");
            }
            break;
    }
}