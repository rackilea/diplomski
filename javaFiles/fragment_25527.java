textView2.setText(String.valueOf(str2[position]));
textView3.setText(String.valueOf(str3[position]));    
textView3.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                String str = textView3.getText().toString(); // use str to share
                return false;
            }
        });