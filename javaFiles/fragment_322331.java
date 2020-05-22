for( int i = 0; i < spinner.getSelectedItem(); i++)
{
TextView textView = new TextView(this);
textView.setText(textArray[i]);
linearLayout.addView(textView);
}