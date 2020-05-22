package com.example.android.dartscounter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.TextView;


import static android.R.string.no;

import static com.example.android.dartscounter.R.id.playerOneScore;
import static com.example.android.dartscounter.R.id.playerTwoScore;


public class MainActivity extends AppCompatActivity {
    int scorePlayerOne = 0;
    int scorePlayerTwo = 0;
    NumberPicker noPicker;
    NumberPicker niPicker;
    int currentValue = 0;
    int currentValue2 = 0;
    //key-pairs for saving
    private static final String STATE_SCORE_ONE = "myInt";
    private static final String STATE_SCORE_TWO = "myIntt";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //below is the code for Number Pickers

        noPicker = (NumberPicker) findViewById(R.id.pickerOne);
        noPicker.setMaxValue(20);
        noPicker.setMinValue(0);
        noPicker.setWrapSelectorWheel(true);


        niPicker = (NumberPicker) findViewById(R.id.pickerTwo);
        niPicker.setMaxValue(20);
        niPicker.setMinValue(0);
        niPicker.setWrapSelectorWheel(true);


        // Check whether we're recreating a previously destroyed instance
        //restoring saved variables
        if (savedInstanceState != null) {
            // Restore value of members from saved state
            scorePlayerOne = savedInstanceState.getInt(STATE_SCORE_ONE);
            scorePlayerTwo = savedInstanceState.getInt(STATE_SCORE_TWO);
            //diplaying restored values
            displayForPlayerOne(scorePlayerOne);
            displayForPlayerTwo(scorePlayerTwo);


        }


    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        // Save the user's current game state
        outState.putInt(STATE_SCORE_ONE, scorePlayerOne);
        outState.putInt(STATE_SCORE_TWO, scorePlayerTwo);
        // Always call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(outState);
    }


    /**
     * Displays the given score for Player1.
     */
    public void displayForPlayerOne(int score) {
        TextView scoreView = (TextView) findViewById(playerOneScore);
        scoreView.setText(String.valueOf(score));

    }

    public void addToPlayerOne(View v) {
        currentValue = noPicker.getValue();
        scorePlayerOne = scorePlayerOne + currentValue;
        displayForPlayerOne(scorePlayerOne);

    }

    public void multiplyTwoPlayerOne(View v) {
        currentValue = noPicker.getValue();
        scorePlayerOne = scorePlayerOne + currentValue * 2;
        displayForPlayerOne(scorePlayerOne);
    }

    public void multiplyThreePlayerOne(View v) {
        currentValue = noPicker.getValue();
        scorePlayerOne = scorePlayerOne + currentValue * 3;
        displayForPlayerOne(scorePlayerOne);

    }

    /**
     * Displays the given score for Player2.
     */

    public void displayForPlayerTwo(int score) {
        TextView scoreView = (TextView) findViewById(playerTwoScore);
        scoreView.setText(String.valueOf(score));

    }

    public void addToPlayerTwo(View v) {
        currentValue2 = niPicker.getValue();
        scorePlayerTwo = scorePlayerTwo + currentValue2;
        displayForPlayerTwo(scorePlayerTwo);

    }

    public void multiplyTwoPlayerTwo(View v) {
        currentValue2 = niPicker.getValue();
        scorePlayerTwo = scorePlayerTwo + currentValue2 * 2;
        displayForPlayerTwo(scorePlayerTwo);
    }

    public void multiplyThreePlayerTwo(View v) {
        currentValue2 = niPicker.getValue();
        scorePlayerTwo = scorePlayerTwo + currentValue2 * 3;
        displayForPlayerTwo(scorePlayerTwo);

    }


    public void reset(View v) {
        scorePlayerOne = 0;
        scorePlayerTwo = 0;
        displayForPlayerTwo(scorePlayerTwo);
        displayForPlayerOne(scorePlayerOne);


    }


}