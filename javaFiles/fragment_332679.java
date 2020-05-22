public class Utils {

    public static void setText(TextView textView, BigDecimal bigDecimal) {
        if(textView != null && bigDecimal != null) {
            // Get context
            Context context = textView.getContext();

            // Set text
            textView.setText(bigDecimal.toString());

            // Set color
            if (bigDecimal.compareTo(BigDecimal.ZERO) == -1) {
                textView.setBackgroundTintList(new ColorStateListStud().getList(ContextCompat.getColor(context, R.color.lightred)));
            } else if (bigDecimal.compareTo(BigDecimal.ZERO) == 1) {
                textView.setBackgroundTintList(new ColorStateListStud().getList(ContextCompat.getColor(context, R.color.lightgreen)));
            } else {
                textView.setBackgroundTintList(new ColorStateListStud().getList(ContextCompat.getColor(context, R.color.transparent)));
            }
        } else {
            Log.e("ERROR", "Error: TextView and/or BigDecimal is null");
        }
}