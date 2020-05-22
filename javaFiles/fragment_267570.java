public void showKeybarod(){
    new Handler().postDelayed(new Runnable() {
        @Override
        public void run() {
            if(getActivity() != null && !getActivity().isFinishing() && getUserVisibleHint()) {
                InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.showSoftInput(editText, InputMethodManager.SHOW_IMPLICIT);
            }
        }
    },300);
}