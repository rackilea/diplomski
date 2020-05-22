amountEdittext.addTextChangedListener(new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        @Override
        public void afterTextChanged(Editable editable) {
            if (editable.length() > 2) {
                for (int i = 0; i < editable.length() - 1; i++) {
                    if (editable.charAt(i) == '$' && editable.charAt(i + 1) == '0') {
                        editable.delete(i + 1, i + 2);
                    }
                }
            }
        }
    });
}