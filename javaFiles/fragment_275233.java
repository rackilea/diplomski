private LinearLayout mdynamiclayout;

mdynamiclayout = (LinearLayout) findViewById(R.id.dynamiclayout);

        mdynamiclayout.removeAllViews();//need to remove the view before it create
        for (int i = 0; i < 6; i++) {//6 is your selected item from spinner it can be any nymber
            TextView t = new TextView(MainActivity.this);
            t.setText("value" + i);
            mdynamiclayout.addView(t);
        }