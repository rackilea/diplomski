for (int i = 0; i < ArrayOfNames.length; i++) {

                final Button myButton = new Button(myView.getContext());
                myButton.setText(RAnames[i]);
                myButton.setId(i + 1);
                myButton.setOnClickListener(this);

                myButton.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                myButton.setTextSize(18);
                myButton.setPadding(20, 0, 20, 0);

                LinearLayout linearlayout = (LinearLayout) myView.findViewById(R.id.btnholder);
                linearlayout.setOrientation(LinearLayout.VERTICAL);

                LinearLayout.LayoutParams buttonParams = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT);
                buttonParams.setMargins(0, 0, 0, 10);

                linearlayout.addView(myButton, buttonParams);
}