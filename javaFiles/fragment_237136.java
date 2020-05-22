Button btnFirst,btnSecond,btnThird;
int counter = 0;

private Button.OnClickListener firstRow = new Button.OnClickListener() {

        @Override
        public void onClick(View v) {
            counter += 1;
            if(counter<2){
            switch (v.getId()) {
                case R.id.btnFirst:
                    btnfirst.setBackgroundColor(Color.parseColor("#FEF3C5"));
                    btnSecond.setClickable(false);
                    btnThird.setClickable(false);
                    break;


                case R.id.btnSecond:
                    btnSecond.setBackgroundColor(Color.parseColor("#FEF3C5"));
                    btnFirst.setClickable(false);
                    btnThird.setClickable(false);
                    break;


                case R.id.btnThird:
                    btnThird.setBackgroundColor(Color.parseColor("#FEF3C5"));
                    btnFirst.setClickable(false);
                    btnSecond.setClickable(false);
                    break;
            }
        }
        else {
//Cnage button backgrounds ad per te need to eac buttons
                counter = 0;
                btnFirst.setClickable(true);
                btnSecond.setClickable(true);
                btnThird.setClickable(true);
            }

        }

    };