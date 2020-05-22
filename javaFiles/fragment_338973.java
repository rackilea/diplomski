span.setSpan(new ClickableSpan() {  
        @Override
        public void onClick(View v) {  
            Log.d("main", "link clicked");
            if (widget instanceof ClickPreventableTextView) {
                if (((ClickPreventableTextView)widget).ignoreSpannableClick())
                    return;
                ((ClickPreventableTextView)widget).preventNextClick();
            }

            Toast.makeText(Main.this, "link clicked", Toast.LENGTH_SHORT).show(); 
        } }, 5, 9, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);