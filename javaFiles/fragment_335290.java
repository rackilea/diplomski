final TextView tv = ...
int column = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                (float) 200.0, getResources().getDisplayMetrics());

SpannableStringBuilder textspan = new SpannableStringBuilder("Charges\nPrice\t$25.00\nShipping\t$155.08\nTax\t$5.11\n");
textspan.setSpan(new TabStopSpan.Standard(column), 0, textspan.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
tv.setText(textspan);