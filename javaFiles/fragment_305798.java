package uk.co.myrayner.sophiestimestables;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int digit1;
    int digit2;
    int show_answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void randomise_digits(View view) {
        Random rand1 = new Random();
        digit1 = rand1.nextInt(12) + 1;
        displaydigit1(digit1);
        Random rand2 = new Random();
        digit2 = rand2.nextInt(12) + 1;
        displaydigit2(digit2);
    }

    public void calculate(View view) {
        show_answer = (digit1 * digit2);
        displayanswer(show_answer);
    }

    private void displaydigit1(int number) {
        TextView digit1TextView = (TextView) findViewById(R.id.digit1);
        digit1TextView.setText("" + number);
    }

    private void displaydigit2(int number) {
        TextView digit2TextView = (TextView) findViewById(R.id.digit2);
        digit2TextView.setText("" + number);
    }

    private void displayanswer(int number) {
        TextView answerTextView = (TextView) findViewById(R.id.show_answer);
        answerTextView.setText("" + number);

    }
}