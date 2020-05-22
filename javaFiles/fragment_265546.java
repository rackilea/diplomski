private static final int RB_ID = 100;
int k=0,len=0,r=0,p = 0,q=0, len = 0;

 LinearLayout mLinearLayout = (LinearLayout) findViewById(R.id.linear1);
 c1 = db.rawQuery("SELECT * FROM QueMotion WHERE AgeGroup ='"+Age+"' LIMIT 5", null);
            c1.moveToFirst();
            int i = c1.getCount();
            rg = new RadioGroup[i];
            rb = new RadioButton[i*5];
            if (i > 0) {
                Log.w("START", "start");
                while (i > 0)
                {
                    TextView title = new TextView(this);
                    questions = c1.getString(1);// retrive from database
                    title.setText(questions);
                    title.setTextColor(Color.BLACK);
                    title.setTypeface(null, Typeface.BOLD);
                    title.setPadding(0, 0, 0, 10);
                    mLinearLayout.addView(title);
                    answers = c1.getString(2);// retrive from database
                    String[] answer = answers.split(",");// will create options for radio button.
                    rg[p] = new RadioGroup(this);
                    rg[p].setOrientation(RadioGroup.VERTICAL);
                    len=len+answer.length;
                    for (int j = 0; j < answer.length; j++)
                    {
                            rb[q] = new RadioButton(this);
                            rg[p].addView(rb[q]);
                            rb[q].setId(k + RB_ID);
                            rb[q].setText(answer[j]);
                            k++;
                            q++;
                    }
                    mLinearLayout.addView(rg[p]);
                    c1.moveToNext();
                    i--;
                    p++;
                }

    //Submit button click
     submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if (rg[0].getCheckedRadioButtonId() == -1)
                {
                    Log.e("Nothing selected", "Nothing selected");
                }
                else
                {
                    for (r = 0; r < len; r++) {
                        if (rb[r].isChecked()) {
                            RadioButton id = (RadioButton) findViewById(rb[r].getId());
                            String radioText = id.getText().toString();
                            c3.moveToFirst();
                            Log.e("RadioString", radioText);
                        } else {
                            Log.e("RadioString", "nothing");
                        }
                    }
                }
            }
        });