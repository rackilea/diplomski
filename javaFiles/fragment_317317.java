public class ActivityEditText extends android.support.v7.widget.AppCompatEditText {
        private TextWatcher tw;
        public ActivityEditText(Context c)
        {
            super(c);
            this.setOurTCL();
        }

        public ActivityEditText(Context context, AttributeSet attrs) {
            super(context, attrs);
            this.setOurTCL();
        }

        public ActivityEditText(Context context, AttributeSet attrs, int defStyleAttr) {
            super(context, attrs, defStyleAttr);
            this.setOurTCL();
        }

        private void setOurTCL()
        {
            this.tw = new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                    InactivityManager.resetTime();
                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            };
            this.addTextChangedListener(this.tw);
        }

        @Override
        public void removeTextChangedListener(TextWatcher watcher) {
            if(!watcher.equals(this.tw))
                super.removeTextChangedListener(watcher);
        }
    }