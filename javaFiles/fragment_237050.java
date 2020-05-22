//lLayout block
        LinearLayout block = new LinearLayout(this);
        block.setOrientation(LinearLayout.HORIZONTAL);
        LinearLayout.LayoutParams blockParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        lTextParams.weight = 1;
        llMain.addView(block, blockParams);

        //lLayout lText
        LinearLayout lText = new LinearLayout(this);
        lText.setBackgroundColor(Color.argb(69,0,0,0));
        lText.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams lTextParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, 0.67f);
        lTextParams.setMargins(10, 10, 0, 10);
        lTextParams.weight = 1;
        lText.setPadding(10, 10, 10, 10);
        block.addView(lText, lTextParams);

        //TextView new_aim
        //LinearLayout.LayoutParams llParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        TextView new_aim = new TextView(this);
        new_aim.setText(aim);
        new_aim.setTextSize(20);
        lText.addView(new_aim, blockParams);

        //TextView new_dscrp
        LinearLayout.LayoutParams lllParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        lllParams.setMargins(20, 0, 0, 0);
        lllParams.weight =1;
        TextView new_dscrp = new TextView(this);
        new_dscrp.setText(description);
        new_dscrp.setTextSize(15);
        lText.addView(new_dscrp, lllParams);

        //Delete TextView
        TextView b_del = new TextView(this);
        b_del.setText("Delete!");
        b_del.setBackgroundColor(Color.argb(69, 0, 0, 0));
        b_del.setTextSize(15);
        LinearLayout.LayoutParams del_Params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT, 0.33f);
        del_Params.setMargins(0, 10, 10, 10);
        del_Params.weight =1;
        b_del.setPadding(10, 10, 10, 10);
        block.addView(b_del, del_Params);