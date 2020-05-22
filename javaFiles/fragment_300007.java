package com.example.bmiworking;

import android.app.Activity;
import android.content.DialogInterface;
import android.view.View.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {
/** Called when the activity is first created. */
Button btn;

@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    btn = (Button) findViewById(R.id.homeClickHandler);
    btn.setOnClickListener(this);
}

    @Override
public void onClick(View v) {
    if (v.getId() == R.id.homeClickHandler) {
        startActivity(new Intent(this, MainMenu.class));
    }
}

public void calculateClickHandler(View view) {
    // make sure we handle the click of the calculator button

    if (view.getId() == R.id.calculateButton) {

        // get the references to the widgets
        EditText weightText = (EditText) findViewById(R.id.weightText);
        EditText heightText = (EditText) findViewById(R.id.heightText);
        TextView resultText = (TextView) findViewById(R.id.resultLabel);

        // get the users values from the widget references

        float weight = Float.parseFloat(weightText.getText().toString());
        float height = Float.parseFloat(heightText.getText().toString());

        // calculate the bmi value

        float bmiValue = calculateBMI(weight, height);

        // interpret the meaning of the bmi value
        String bmiInterpretation = interpretBMI(bmiValue);

        // now set the value in the result text

        resultText.setText(bmiValue + "-" + bmiInterpretation);
    }
}

// the formula to calculate the BMI index

// check for http://en.wikipedia.org/wiki/Body_mass_index
private float calculateBMI(float weight, float height) {

    return (float) (weight * 4.88 / (height * height));
}

// interpret what BMI means
private String interpretBMI(float bmiValue) {

    if (bmiValue < 16) {
        return "Severely Underweight - See Weight Gain";
    } else if (bmiValue < 18.5) {

        return "Underweight - See Weight Gain";
    } else if (bmiValue < 25) {

        return "Normal - No Recomendations";
    } else if (bmiValue < 30) {

        return "Overweight - See Weight Loss";
    } else {
        return "Obese - See Weight Loss";
    }

}

}