for(int i = 0; i<num;i++) {
        LinearLayout linear1 = new LinearLayout(this);
        linear1.setOrientation(LinearLayout.HORIZONTAL);
        linearlayout.addView(linear1);


        b = new Button(this);
        b.setText("Button" + i);
        b.setId(i);
        b.setTextSize(10);
        b.setOnClickListener(new OnClickListener() {
            void onClick(View v) {
                Log.i("TAG", "The index is" + index);
            }
        });
        b.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
        linear1.addView(b);
        }
    }