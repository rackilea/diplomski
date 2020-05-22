private int clickcount = 3;
@Override
public void onClick(View v) {

    // Do button click handling here
    if ( posisi2==getAdapterPosition() ) {
            clickcount--;
            tombolbaca.setText("Baca " + clickcount + "x");

            // try to stop count but it can't
            if (clickcount <=0)  <== make this change
            {
                mTitle.setVisibility(View.GONE);
                rl2.setVisibility(View.GONE);
            }

    } // adapter

}