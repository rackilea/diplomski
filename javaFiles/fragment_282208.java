package com.example.checkdoubltap;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class CheckLayoutParams extends Activity {


@Override
protected void onCreate(Bundle savedInstanceState) {
    // TODO Auto-generated method stub
    super.onCreate(savedInstanceState);
    setContentView(R.layout.lin);
    ListView list = (ListView) findViewById(R.id.listview);
    boolean[] isChecked = new boolean[countryStrings.length];
    for(int i=0;i<countryStrings.length; i++){
        isChecked[i] = false;
    }
    CheckBoxAdapter adapter = new CheckBoxAdapter(CheckLayoutParams.this, countryStrings, isChecked);

    list.setAdapter(adapter);

}

private String[] countryStrings = { "Afghanistan", "Albania",
        "Algeria", "Andorra", "Angola", "Anguilla", "Antigua and Barbuda",
        "Argentina", "Armenia", "Aruba", "Ascension Island", "Australia",
        "Austria", "Azerbaijan", "Bahamas", "Bahrain", "Bangladesh",
        "Barbados", "Belarus", "Belgium", "Belize", "Benin", "Bermuda",
        "Bhutan", "Bolivia", "Bosnia and Herzegovina", "Botswana",
        };
}