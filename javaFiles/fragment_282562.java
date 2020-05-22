TextView resultView = new TextView(this);
final String SyriaText = "Syria";
final String OtherText = "Other Text";
final String result = SyriaText + "  " + OtherText;
final SpannableString finalResult = new SpannableString(result);
finalResult.setSpan((new AlignmentSpan.Standard(Alignment.ALIGN_CENTER), 0, SyriaText.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
resultView.setText(finalResult);