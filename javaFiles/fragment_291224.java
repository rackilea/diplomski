layout.setOrientation(LinearLayout.VERTICAL);
    sv.addView(layout);
    for (int i = 0; i < 6; i++) {
         Linearlayout row = new LinearLayout(this);
         row.setLayoutParams(new LinearLayout.LayoutParams
                  (LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));    
         for (int  j = 0; j < 4; j++) {
                Button btn = new Button(this);
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams
                  (LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
                lp.weight = 1; 
                btn.setLayoutParams(lp); 
                btn.setText("Button");
                btn.setLayoutParams(params);
                row.addView(btn);
         }
         layout.addView(row);
    }
    this.setContentView(sv);