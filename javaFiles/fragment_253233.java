View textView;
RelativeLayout layout = new RelativeLayout (this);
setContentView(layout);

for(int i=0;i<10;i++){
        textView = new TextView(this);
        textView.setId(i);
        layout.addView(textView);
}

/* FOR LOOP THAT ONE */
TextView referencedTextView = (TextView) layout.findViewById(5);
referencedTextView.setVisibility(View.GONE);