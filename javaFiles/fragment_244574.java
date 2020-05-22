mPatentNameET.setFilters(new InputFilter[] {
                new InputFilter() {
                    public CharSequence filter(CharSequence src, int start,
                                               int end, Spanned dst, int dstart, int dend) {
                        if(src.equals("")){ // for backspace
                            return src;
                        }
                        if((mPatentNameET.getText().toString() + src).matches("[a-zA-Z ]+")  ||
                                (mPatentNameET.getText().toString() + src).matches("^[123456789][0-9]*$")){
                            return src;
                        }
                        return "";
                    }
                }
        });