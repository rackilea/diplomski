package com.example.converter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class TempFragment extends Fragment 
  implements OnClickListener 
  {
  private EditText text;
  Button b;
  View view;
@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {

    view = inflater.inflate(R.layout.fragment_temp, container, false);
    text = (EditText) view.findViewById(R.id.editText1);
    b = (Button) view.findViewById(R.id.button1);
    b.setOnClickListener(this);         
    return view;

}

// this method is called at button click because we assigned the name to the
  // "OnClick property" of the button
  public void onClick(View v) {
    switch (v.getId()) {
    case R.id.button1:
      RadioButton celsiusButton = (RadioButton) view.findViewById(R.id.radio0);
      RadioButton fahrenheitButton = (RadioButton) view.findViewById(R.id.radio1);
      if (text.getText().length() == 0) {
          Toast.makeText(getActivity(), "Please enter a valid number", 
                  Toast.LENGTH_LONG).show();
        return;
      }

      float inputValue = Float.parseFloat(text.getText().toString());
      if (celsiusButton.isChecked()) {
        text.setText(String
            .valueOf(ConverterUtil.convertFahrenheitToCelsius(inputValue)));
        celsiusButton.setChecked(false);
        fahrenheitButton.setChecked(true);
      } else {
        text.setText(String
            .valueOf(ConverterUtil.convertCelsiusToFahrenheit(inputValue)));
        fahrenheitButton.setChecked(false);
        celsiusButton.setChecked(true);
      }
      break;
    }
  } 
}