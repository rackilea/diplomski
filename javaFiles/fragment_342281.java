InputFilter filter = new InputFilter() { 
    public CharSequence filter(CharSequence source, int start, int end, 
            Spanned dest, int dstart, int dend) { 
            for (int i = start; i < end; i++) { 
                    if (!Character.isLetterOrDigit(source.charAt(i))) { 
                            return ""; 
                    } 
            } 
            return null; 
    } 
    }; 

    edit.setFilters(new InputFilter[]{filter});