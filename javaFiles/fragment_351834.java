package com.emanuelolsson.simplehangman;

import database.DBAdapter;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class HangMan extends Activity {

    // DECLARE NEEDED VARIABLES  
    private Button newGameButton, enterLetterButton;
    private EditText userInput;
    private TextView wordHolder;
    private ImageView imageOne, imageTwo, imageThree, imageFour, imageFive, imageSix, imageSeven, imageEight, winner, hanged;
    private String hiddenWord, randomedWord;
    private int count = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hang_man);
        DBAdapter db = new DBAdapter(this);

        // ASSIGN OBJECTS
        newGameButton = (Button) findViewById(R.id.newGame);
        enterLetterButton = (Button) findViewById(R.id.enter);
        wordHolder = (TextView) findViewById(R.id.wordHolder);
        userInput = (EditText) findViewById(R.id.userInput);
        imageOne = (ImageView) findViewById(R.id.imageView1);
        imageTwo = (ImageView) findViewById(R.id.imageView2);
        imageThree = (ImageView) findViewById(R.id.imageView3);
        imageFour = (ImageView) findViewById(R.id.imageView4);
        imageFive = (ImageView) findViewById(R.id.imageView5);
        imageSix = (ImageView) findViewById(R.id.imageView6);
        imageSeven = (ImageView) findViewById(R.id.imageView7);
        imageEight = (ImageView) findViewById(R.id.imageView8);
        winner = (ImageView) findViewById(R.id.winner);
        hanged = (ImageView) findViewById(R.id.hanged);
        imageOne.setVisibility(View.INVISIBLE);
        imageTwo.setVisibility(View.INVISIBLE);
        imageThree.setVisibility(View.INVISIBLE);
        imageFour.setVisibility(View.INVISIBLE);
        imageFive.setVisibility(View.INVISIBLE);
        imageSix.setVisibility(View.INVISIBLE);
        imageSeven.setVisibility(View.INVISIBLE);
        imageEight.setVisibility(View.INVISIBLE);
        winner.setVisibility(View.INVISIBLE);
        hanged.setVisibility(View.INVISIBLE);
        wordHolder.setVisibility(View.VISIBLE);


        // ADD LISTENERS
        newGameButton.setOnClickListener(new OnClickListener(){
            public void onClick(View arg0) {

                newGame();

            }
        });

        enterLetterButton.setOnClickListener(new OnClickListener(){
            public void onClick(View arg0) {

                if (!(userInput.getText().toString().isEmpty()) )
                {
                    guess();
                } else if (userInput.getText().toString().isEmpty())
                {
                    Toast toast = Toast.makeText(getApplicationContext(), "You need to insert a letter", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });
        db.open();
        db.fill();
        randomedWord = db.randomize();
        invWord();
        wordHolder.setText(hiddenWord);
        db.clear();
        db.close();
    }

    public void newGame() {
        DBAdapter db = new DBAdapter(this);
        count = 0;
        imageOne.setVisibility(View.INVISIBLE);
        imageTwo.setVisibility(View.INVISIBLE);
        imageThree.setVisibility(View.INVISIBLE);
        imageFour.setVisibility(View.INVISIBLE);
        imageFive.setVisibility(View.INVISIBLE);
        imageSix.setVisibility(View.INVISIBLE);
        imageSeven.setVisibility(View.INVISIBLE);
        imageEight.setVisibility(View.INVISIBLE);
        winner.setVisibility(View.INVISIBLE);
        hanged.setVisibility(View.INVISIBLE);

        db.open();
        db.fill();
        randomedWord = db.randomize();
        invWord();
        wordHolder.setText(hiddenWord);
        db.clear();
        db.close();
    }

    public void invWord() 
    {
        hiddenWord = randomedWord;
        hiddenWord = hiddenWord.replaceAll(".", "_" +" ");
    }

    public void guess()
    {
        char guess = userInput.getText().charAt(0);
        StringBuilder builder = new StringBuilder(hiddenWord);
        String j = ""+guess;
        int index = randomedWord.indexOf(guess);

        if (randomedWord.contains(j))
        {
            while (index >= 0) 
            {
                builder.setCharAt(index*2, guess);
                index = randomedWord.indexOf(guess, index + 1);
                hiddenWord = builder.toString().trim();
                wordHolder.setText(hiddenWord);
                if (!(hiddenWord.toString().contains("_".toString())) )
                {
                    winner();
                }
            }   
        }
        else 
        {
            showImages();
        }
    }

    private void winner()
    {
        imageOne.setVisibility(View.INVISIBLE);
        imageTwo.setVisibility(View.INVISIBLE);
        imageThree.setVisibility(View.INVISIBLE);
        imageFour.setVisibility(View.INVISIBLE);
        imageFive.setVisibility(View.INVISIBLE);
        imageSix.setVisibility(View.INVISIBLE);
        imageSeven.setVisibility(View.INVISIBLE);
        imageEight.setVisibility(View.INVISIBLE);
        winner.setVisibility(View.VISIBLE);
    }
    private void showImages() {

        count ++;

        if (count == 1) 
        {
            imageOne.setVisibility(View.VISIBLE);
        }
        else if (count == 2)
        {
            imageTwo.setVisibility(View.VISIBLE);
        }
        else if (count == 3) 
        {
            imageThree.setVisibility(View.VISIBLE);
        }
        else if (count == 4)
        {
            imageFour.setVisibility(View.VISIBLE);
        }
        else if (count == 5) 
        {
            imageFive.setVisibility(View.VISIBLE);
        }
        else if (count == 6)
        {
            imageSix.setVisibility(View.VISIBLE);
        }
        else if (count == 7) 
        {
            imageSeven.setVisibility(View.VISIBLE);
        }
        else if (count == 8)
        {   
            gameEnd();
        }

    }

    private void gameEnd() 
    {

        imageOne.setVisibility(View.INVISIBLE);
        imageTwo.setVisibility(View.INVISIBLE);
        imageThree.setVisibility(View.INVISIBLE);
        imageFour.setVisibility(View.INVISIBLE);
        imageFive.setVisibility(View.INVISIBLE);
        imageSix.setVisibility(View.INVISIBLE);
        imageSeven.setVisibility(View.INVISIBLE);
        imageEight.setVisibility(View.VISIBLE);
        hanged.setVisibility(View.VISIBLE);
        wordHolder.setText(randomedWord);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_hang_man, menu);
        return true;
    }
}