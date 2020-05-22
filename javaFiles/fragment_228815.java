myedittext.addTextChangedListener(new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if(start < s.length() - 1 || count > before){
                spannableString.setSpan(new ForegroundColorSpan(Color.parseColor(txtColor)), start, start+1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            }

        }
        @Override
        public void afterTextChanged(Editable s) {
        }
    });
}