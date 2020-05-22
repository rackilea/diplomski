@Override
public void onClick(View v)
{   
     int BLACK_AND_WHITE_MULTIUPLIER = 4200;
     int COLOR_MULTIUPLIER = 6400;
    switch (v.getId())
    {
        case R.id.btCalculate:

            int multiplier = 0;

            if (heading.getText().toString.equals("something")) {

                multiplier = COLOR_MULTIUPLIER;

            } else {

                multiplier = BLACK_AND_WHITE_MULTIUPLIER;

            }

            //int multiplier = rbColor.isChecked() ? COLOR_MULTIUPLIER
            //        : BLACK_AND_WHITE_MULTIUPLIER;
            int column = Integer.parseInt((String) spColumn
                    .getSelectedItem());
            int inch = Integer.parseInt((String) spInch.getSelectedItem());
            tvAmount.setText((multiplier * column * inch) + "");
            break;
    }
}