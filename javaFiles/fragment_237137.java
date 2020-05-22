Button btnFirst,btnSecond,btnThird;

   private Button.OnClickListener firstRow = new Button.OnClickListener() {

        @Override
        public void onClick(View v) {

            switch (v.getId()) {
                case R.id.btnFirst:
                    btnFirst.setBackgroundColor(Color.parseColor("#FEF3C5"));
                    //Change btnFirst,btnThird backgrounds as default background
                    break;


                case R.id.btnSecond:
                    btnSecond.setBackgroundColor(Color.parseColor("#FEF3C5"));
                    //Change btnFirst,btnThird backgrounds as default background
                    break;


                case R.id.btnThird:
                    btnThird.setBackgroundColor(Color.parseColor("#FEF3C5"));
                    //Change btnFirst,btnSecond backgrounds as default background for example given below
                    btnFirst.setBackgroundColor(Color.parseColor("#defaultColor"));
                    btnSecond.setBackgroundColor(Color.parseColor("#defaultColor"));
                    break;
            }

        }

    };