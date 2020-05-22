RelativeLayout rl=(RelativeLayout)findViewById(R.id.RelativeLayout); //getting the view from the xml file. Keep in mind that the id is defiend in the xml file by you
List<PaymentOption> paymentOptions = aTradeItem.getPaymentOptions();

LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);
lp.setMargins(ImageUtils.dpToPx(16), ImageUtils.dpToPx(4), ImageUtils.dpToPx(16), ImageUtils.dpToPx(4));

LinearLayout.LayoutParams lineparams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, ImageUtils.dpToPx(1));
lineparams.setMargins(0, ImageUtils.dpToPx(4), 0, ImageUtils.dpToPx(4));

if (paymentOptions != null && paymentOptions.size() > 0) {
  for (PaymentOption t : paymentOptions) {
    LinearLayout paymentOptionLayout = new LinearLayout(getContext());
    paymentOptionLayout.setOrientation(LinearLayout.HORIZONTAL);
    paymentOptionLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT));

    TextView heading = new TextView(getContext());
    heading.setText(t.getDescription());
    heading.setTextColor(getResources().getColor(R.color.light_text));
    heading.setLayoutParams(lp);

    paymentOptionLayout.addView(heading);
    rl.addView(paymentOptionLayout);  //adding the view to the parent view
  }
}