@Override
        public boolean dispatchTouchEvent(MotionEvent ev) {
                if (getCurrentFocus() != null) {
                      InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                      imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
                    }
            return super.dispatchTouchEvent(ev);
        }