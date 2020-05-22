SpannableString ss = new SpannableString("Hello World");
    ClickableSpan span1 = new ClickableSpan() {
        @Override
        public void onClick(View textView) {
            // do some thing
        }
    };

    ClickableSpan span2 = new ClickableSpan() {
        @Override
        public void onClick(View textView) {
            // do another thing
        }
    };

    ss.setSpan(span1, 0, 4, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
    ss.setSpan(span2, 6, 10, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

    textView.setText(ss);
    textView.setMovementMethod(LinkMovementMethod.getInstance());