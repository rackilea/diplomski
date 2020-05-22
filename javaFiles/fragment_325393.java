public void beforeTextChanged(CharSequence s, int start, int count,
                int after) {
            beforeText = s.toString() ;
        }

        public void afterTextChanged(Editable s) {
            int index = input.getSelectionEnd();
            String nowstr;

            if (index == 0) {
                // do nothing
            } else {
                if (beforeText.length() < s.toString().length()) {
                    nowstr = s.toString();
                    char nowstr_array[] = nowstr.toCharArray();
                    String show_input = String.valueOf(nowstr_array[index - 1]);

                    SpannableStringBuilder spann = new SpannableStringBuilder(
                            show_input);
                    AbsoluteSizeSpan word_size = new AbsoluteSizeSpan(40, true);
                    spann.setSpan(word_size, 0, 1,
                            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                    input.removeTextChangedListener(this) ;
                    input.getText().replace(index-1, index, spann) ;
                    input.addTextChangedListener(this) ;

                }
            }
        }

    });