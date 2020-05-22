commentEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String comment = editable.toString();
                if (comment.indexOf('@') != -1) {
                    //Asumming the name string
                    String name = "Andrea";
                    int atIndex = comment.indexOf('@');
                    int endIndex = atIndex + name.length() + 1;
                    if (endIndex == -1 || endIndex > editable.length()) {
                        endIndex = editable.length();
                    }
                    if (comment.toLowerCase().contains(name.toLowerCase())) {
                        editable.setSpan(new StyleSpan(Typeface.BOLD), atIndex, endIndex, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                    } else {
                        StyleSpan[] spannable = editable.getSpans(atIndex, endIndex, StyleSpan.class);
                        if (spannable != null && spannable.length > 0) {
                            for (int i = 0; i < spannable.length; i++) {
                                editable.removeSpan(spannable[i]);
                            }
                        }

                    }
                }
            }
        });