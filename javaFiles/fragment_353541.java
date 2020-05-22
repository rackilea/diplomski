@Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

        // Save UI state changes to the savedInstanceState.
        // This bundle will be passed to onCreate if the process is
        // killed and restarted.
        savedInstanceState.putInt("POINT_VALUE", pointValue);
        savedInstanceState.putInt("ROLL_TOTAL", rollTotal);
        savedInstanceState.putInt("WINS_COUNTER", winsCounter);
        savedInstanceState.putInt("LOSE_COUNTER", loseCounter);
        savedInstanceState.putInt("DIE_1", d1);
        savedInstanceState.putInt("DIE_2", d2);
    } // end onSavedInstanceState