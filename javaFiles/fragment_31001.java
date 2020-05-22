public static class BlockingAutoCompleteTextView extends
        AutoCompleteTextView {

    public BlockingAutoCompleteTextView(Context context) {
        super(context);
    }

    @Override
    protected void performFiltering(CharSequence text, int keyCode) {           
        // nothing, block the default auto complete behavior
    }

}