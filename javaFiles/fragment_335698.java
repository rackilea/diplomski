package com.shutter2000.www.shutter_2000_oms;    
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.view.View.OnClickListener;    


public class SiteVisitDetails extends Activity implements OnClickListener{

public EditText mCusName;
public EditText mOrderID;
public EditText mProjectID;
public EditText mHeightWidth;
public EditText mNote;
public Button mSubmitButton;


@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_site_visit_details);

    //initialize text fields
    mCusName = (EditText) findViewById(R.id.txtCusName);
    mOrderID = (EditText) findViewById(R.id.txtOrderID);
    mProjectID = (EditText) findViewById(R.id.txtProjectID);
    mHeightWidth = (EditText) findViewById(R.id.txtHeightWidth);
    mNote = (EditText) findViewById(R.id.txtNote);
    mSubmitButton = (Button) findViewById(R.id.btnSubmit);

    //listen to submit button click event

    mSubmitButton.setOnClickListener(this);

}

@Override
public void onClick(View v) {
     if (v.getId() == R.id.mSubmitButton) {
         Toast.makeText(this,"Successfully sent!",Toast.LENGTH_LONG).show();             
     }

}

@Override
public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.site_visit_details, menu);
    return true;
}

public void addItemsToProductSpinner() {
    Spinner spinner = (Spinner) findViewById(R.id.spnProducts);
    // Create an ArrayAdapter using the string array and a default spinner layout
    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
            R.array.products, android.R.layout.simple_spinner_item);
    // Specify the layout to use when the list of choices appears
    android.R.layout.simple_spinner_item
    // Apply the adapter to the spinner
    spinner.setAdapter(adapter);
}

@Override
public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();
    if (id == R.id.action_settings) {
        return true;
    }
    return super.onOptionsItemSelected(item);
}
}