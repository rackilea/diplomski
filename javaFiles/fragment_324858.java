for (int i = 0; i <23; i++) {

            TableRow row= new TableRow(this);
            TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT);
            row.setLayoutParams(lp);


            tv = new TextView(this);
            tv.setText(array[i]);


             ImageView image65 = new ImageView(this);
             Drawable d = getResources().getDrawable(R.drawable.ic_yes);
             image65.setImageDrawable(d);
             image65.setLayoutParams(new TableRow.LayoutParams(40, 40));



            row.addView(tv,1);
            row.addView(image65,0);
            ll.addView(row,i);
        }