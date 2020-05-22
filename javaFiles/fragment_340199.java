et.setFilters(new InputFilter[] {
                 new DigitsKeyListener(Boolean.FALSE, Boolean.TRUE) {
                int beforeDecimal = 5, afterDecimal = 2;

                @Override
                public CharSequence filter(CharSequence source, int start, int end,
                        Spanned dest, int dstart, int dend) {
                    String temp = et.getText() + source.toString();

                    if (temp.equals(".")) {
                        return "0.";
                    }
                    else if (temp.toString().indexOf(".") == -1) {
                        // no decimal point placed yet
                        if (temp.length() > beforeDecimal) {
                            return "";
                        }
                    } else {
                        temp = temp.substring(temp.indexOf(".") + 1);
                        if (temp.length() > afterDecimal) {
                            return "";
                        }
                    }

                    return super.filter(source, start, end, dest, dstart, dend);
                }
            }
    });