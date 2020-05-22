CardView card = new CardView(getApplicationContext());

            // Set the CardView layoutParams
            LayoutParams params = new LayoutParams(
                    LayoutParams.WRAP_CONTENT,
                    LayoutParams.WRAP_CONTENT
            );
            card.setLayoutParams(params);



 // Put the Editext in CardView
card.addView(et);

// Finally, add the CardView in root layout
layout.addView(card);