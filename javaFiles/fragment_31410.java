public void onClick(View v) {
    RadioButton uans=(RadioButton)findViewById(rg.getCheckedRadioButtonId());
    String ansText= uans.getText().toString();

    if (ansText.equalsIgnoreCase(ans[flag]))
    {
        correct++;
        flag++;
    }
    else
    {
        wrong++;
        // You may need to change Toast.LENGTH_SHORT to 1000 depending on your environment.
        Toast.makeText(FamilyQuestion.this, "Wrong answer,please try again", Toast.LENGTH_SHORT).show();
    }

    if(flag<Question.length)
    {
        tv.setText(Question[flag]);
        bt1.setText(opt[flag*3]);
        bt2.setText(opt[(flag*3)+1]);
        bt3.setText(opt[(flag*3)+2]);
    }
    else
    {
        if(Test.tbflag)
        {
            mark=correct-wrong;
        }
        else
        {
            mark=correct;
        }
        Intent in=new Intent(getApplicationContext(),ResultActivity.class);
        in.putExtra("question", "family");
        startActivity(in);
    }
}