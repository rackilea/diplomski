float fAF = 0.0f;
String strAF = tvAF.getText().toString();

if (strAF.matches("OptionA")){
    fAF = 1.20f;
}else if (strAF.matches("OptionB")){
    fAF = 1.375f;
}else if (strAF.matches("OptionC")){
    fAF = 1.55f;
}else if (strAF.matches("OptionD")){
    fAF = 1.725f;
}else if (strAF.matches("OptionE")){
    fAF = 1.90f;
}

final float fTdee = bmr*fAF;

Intent in2 = new Intent(getApplicationContext(),  CaloriesPage.class);
in2.putExtra("mTdee",fTdee);
startActivity(in2);