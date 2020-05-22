// Wiring in my 2 main aspects relativeLayout + Button
relativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout);
button = (Button) findViewById(R.id.btn);

//my trigger but in your case, it can be anything
button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            CardView card = new CardView(mContext);

            // Set the CardView layoutParams
            LayoutParams layoutParams = new LayoutParams(
                    LayoutParams.WRAP_CONTENT,
                    LayoutParams.WRAP_CONTENT
            );
            card.setLayoutParams(layoutParams );

            // Setting different attributes
            card.setRadius(9);
            card.setContentPadding(15, 15, 15, 15);
            card.setCardBackgroundColor(Color.parseColor("#FFC6D6C3"));
            card.setMaxCardElevation(15);
            card.setCardElevation(9);

            // Initialize a new TextView to put in CardView
            TextView tv = new TextView(mContext);
            tv.setLayoutParams(layoutParams );
            tv.setText("My CardView");
            tv.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 30);
            tv.setTextColor(Color.RED);

            // Put the TextView inside CardView
            card.addView(tv);

            // Finally, add the CardView in root layout
            relativeLayout.addView(card);
        }
    });