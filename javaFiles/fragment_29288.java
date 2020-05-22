for(int spanCount = 0 ; spanCount < span.length ; spanCount++){

    spans[spanCount] = new ClickableSpan() {
        @Override
        public void onClick(View textView) {

            TextView v = (TextView)textView ;
            String text = v.getText().toString() ;
                Log.d("View" , text);
            }
        };
    }