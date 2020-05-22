package com.yallatschikowski.exposurecalculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class ExposureCalculatorActivity extends Activity {

    Spinner shutterSpinner;
    Spinner evSpinner;
    String[] shutterValues;
    String[] evValues;
    Button calcButton;
    TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exposure_calculator);

        // connect the variables to the layout
        shutterSpinner = (Spinner) findViewById(R.id.shutterSpinner);
        evSpinner = (Spinner) findViewById(R.id.evSpinner);
        shutterValues = getResources().getStringArray(
                R.array.shutterspeeds_array);
        evValues = getResources().getStringArray(R.array.ev_array);
        calcButton = (Button) findViewById(R.id.calcBT);
        resultTextView = (TextView) findViewById(R.id.resultTV);

        addItemsOnSpinner();
        addListenerOnButton();
    }

    private void addListenerOnButton() {
        calcButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                int resultID = calculatExposure();

                // check if the resultID is too big
                if (resultID < shutterValues.length) {
                    resultTextView.setText(shutterValues[resultID]);
                } else {
                    resultTextView.setText("Value > 1min");
                }
            }
        });

    }

    protected int calculatExposure() {

        long shutterID = shutterSpinner.getSelectedItemId();
        long evID = evSpinner.getSelectedItemId();
        return (int) (shutterID + evID);
    }

    private void addItemsOnSpinner() {

        ArrayAdapter<String> shutterAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, shutterValues);
        shutterAdapter
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        shutterSpinner.setAdapter(shutterAdapter);

        ArrayAdapter<String> evAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, evValues);
        evAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        evSpinner.setAdapter(evAdapter);
    }

}