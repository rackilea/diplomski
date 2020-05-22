@Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        // Restore UI state from the savedInstanceState.
        // This bundle has also been passed to onCreate.
        pointValue = savedInstanceState.getInt("POINT_VALUE");
        rollTotal = savedInstanceState.getInt("ROLL_TOTAL");
        winsCounter = savedInstanceState.getInt("WINS_COUNTER");
        loseCounter = savedInstanceState.getInt("LOSE_COUNTER");
        d1 =  savedInstanceState.getInt("DIE_1");
        d2 =  savedInstanceState.getInt("DIE_2");

        roll.setText(String.valueOf(rollTotal));
        point.setText(String.valueOf(pointValue));
        winTotal.setText(String.valueOf(winsCounter));
        lostTotal.setText(String.valueOf(loseCounter));

        if(d1 == 1) {
            dice1Image.setImageResource(R.drawable.die1);
        }
        else if(d1 == 2) {
            dice1Image.setImageResource(R.drawable.die2);
        }
        else if(d1 == 3) {
            dice1Image.setImageResource(R.drawable.die3);
        }
        else if(d1 == 4) {
            dice1Image.setImageResource(R.drawable.die4);
        }
        else if(d1 == 5) {
            dice1Image.setImageResource(R.drawable.die5);
        }
        else if(d1 == 6) {
            dice1Image.setImageResource(R.drawable.die6);
        }

        if(d2 == 1) {
            dice2Image.setImageResource(R.drawable.die1);
        }
        else if(d2 == 2) {
            dice2Image.setImageResource(R.drawable.die2);
        }
        else if(d2 == 3) {
            dice2Image.setImageResource(R.drawable.die3);
        }
        else if(d2 == 4) {
            dice2Image.setImageResource(R.drawable.die4);
        }
        else if(d2 == 5) {
            dice2Image.setImageResource(R.drawable.die5);
        }
        else if(d2 == 6) {
            dice2Image.setImageResource(R.drawable.die6);
        }
    } // end onRestoreInstanceState method