private class MyClickableSpannable extends ClickableSpan {

    private final String mStringToShow;


    public MyClickableSpannable(String stringToShow) {
        mStringToShow = stringToShow;
    } 

    @Override
    public void onClick(View widget) {
         Toast.makeText(context, mStringToShow, Toast.LENGHT_SHORT).show();
    }
}