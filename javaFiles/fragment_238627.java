RxTextView.textChangeEvents(mTextView)
  .map(new Func1<CharSequence, String>() {
    @Override
    public void call(CharSequence charSequence) {
      return String.valueOf(charSequence);
    }
  })
  ...