ArrayList<Integer> randomized = Random(length);
for(int i=0;i<length;i++){
            int k = randomized.get(i);
                TextView tv = new TextView(this);
                tv.setText(String.valueOf(char_text[k]));
                tv.setId(k);
                tv.setTextSize(30);
                tv.setBackgroundColor(0xff00ff00);
                tv.setPadding(5, 5, 5, 5);
                tv.setOnTouchListener(new MyTouchListener());
                layout.addView(tv);
        }