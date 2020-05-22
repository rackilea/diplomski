public class RestrictedNumberDocumentFilter extends DocumentFilter{

    private double min;
    private double max;

    public RestrictedNumberDocumentFilter(double min, double max){
        if ( max < min ){
            double temp = max;
            max = min;
            min = temp;
        }
        this.min = min;
        this.max = max;
    }

    @Override
    public void insertString(FilterBypass fb, int off, String str, AttributeSet attr) throws BadLocationException {
        StringBuilder sb = new StringBuilder(fb.getDocument().getText(0, fb.getDocument().getLength()));
        if ( test(sb.toString()) ){
            fb.insertString(off, str, attr);
        }else{
            //warn
        }

    } 
    @Override
    public void replace(FilterBypass fb, int off, int len, String str, AttributeSet attr)throws BadLocationException{
        StringBuilder sb = new StringBuilder(fb.getDocument().getText(0, fb.getDocument().getLength()));
        sb.replace(off, off+len, str);
        if ( test(sb.toString()) ){
            fb.replace(off, len, str, attr); 
        }else{
            //warn
        }

    }
    /**
     * Sanitized the input
     * @param val
     * @return
     */
    private boolean test(String val){
        try{
            double d = Double.parseDouble(val);
            if ( d >= min && d <= max ){
                return true;
            }
            return false;
        }catch(NumberFormatException e){
            return false;
        }
    }
}