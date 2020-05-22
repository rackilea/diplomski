LinearLayout symbolsTableLayout = new LinearLayout(context);
    symbolsTableLayout.setId(View.generateViewId());
    symbolsTableLayout.setBackgroundColor(Color.rgb(198,18,250));
    symbolsTableLayout.setHorizontalGravity(Gravity.CENTER);
    symbolsTableLayout.setVerticalGravity(Gravity.CENTER);

    addView(symbolsTableLayout, LinearLayout.LayoutParams.MATCH_PARENT,488);

    GridLayout tableLayout = new GridLayout(context);
    tableLayout.setColumnCount(col_count);
    tableLayout.setRowCount(row_count);
//    tableLayout.setBackgroundColor(Color.rgb(198,128,230));    // Color.rgb(198,128,230)   pink

    symbolsTableLayout.addView(tableLayout, 1100,398);

    symbolButton = new Button[row_count][col_count];
    for (int row = 0; row < row_count; row++)
      for (int col = 0; col < col_count; col++)
      {
        symbolButton[row][col] = new Button(context);
        symbolButton[row][col].setText(row*col_count+col+1+"");
        symbolButton[row][col].setTypeface(Typeface.MONOSPACE);
        symbolButton[row][col].setAllCaps(false);
        symbolButton[row][col].setTextSize(12);
        symbolButton[row][col].setOnClickListener(Symbol_Button_Listener);

        GradientDrawable drawable = new GradientDrawable();
        drawable.setShape(GradientDrawable.RECTANGLE);
        drawable.setCornerRadii(new float[]{6, 6, 6, 6, 6, 6, 6, 6});
        drawable.setStroke(3, Color.rgb(153, 187, 255));
        drawable.setColor(Color.rgb(214, 215, 215));
        symbolButton[row][col].setBackground(drawable);
        symbolButton[row][col].setPadding(0,0,0,0);
        tableLayout.addView(symbolButton[row][col], 44, 50);
      }