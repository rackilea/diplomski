import java.util.Calendar;

import android.os.Bundle;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



public class EditResult1 extends Activity {

    // TableLayout tablelayout_Log = null;
    Button saveButton = null;
    Button cancelButton = null;
   // Button searchButton = null;
    static EditText dateEdit; 
    EditText priceEdit;
    EditText pumpEdit;
    TextView costView;
    EditText odometerEdit;
    TextView fconView;
    TextWatcher textWatcher;
    String priceEditStr ="",pumpEditStr="";
    String  odmEditStr = "";
    String lastOdm = "";

    double result;
    double resultCon;
    private int mYear;
    private int mMonth;
    private int mDay;

    SharedPreferences sp;

    static final int DATE_DIALOG_ID = 0;

    public boolean isNumeric(String str)
    {
        return str.matches("-?\\d+(\\.\\d+)?"); 
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.edit_sample);
        costView = (TextView)findViewById(R.id.tcost);
        dateEdit = (EditText)findViewById(R.id.date);
        priceEdit = (EditText)findViewById(R.id.fuelprice);
        pumpEdit = (EditText)findViewById(R.id.fuelpump);
        odometerEdit = (EditText)findViewById(R.id.odometer);
        fconView = (TextView)findViewById(R.id.fcon);

        /**
         * Shared preference 
         **/
        sp=this.getSharedPreferences("result_store", MODE_WORLD_READABLE);
        lastOdm=sp.getString("ODO", lastOdm);

        if(lastOdm.trim().equalsIgnoreCase("NA"))
            Toast.makeText(getApplicationContext(), " "+lastOdm.trim(), Toast.LENGTH_LONG).show();
        else
            Toast.makeText(getApplicationContext(), " "+lastOdm.trim(), Toast.LENGTH_LONG).show();

        dateEdit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
               // showDialog(DATE_DIALOG_ID);
                DialogFragment newFragment = new DatePickerFragment();
                newFragment.show(getFragmentManager(), "datePicker");
            }
        });


           priceEdit.addTextChangedListener(new TextWatcher() {

               @Override
               public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

               }

               @Override
               public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

               }

               @Override
               public void afterTextChanged(Editable editable) {
                  //here, after we introduced something in the EditText we get the string from it
                   if(!priceEdit.getText().toString().trim().equalsIgnoreCase("") && !priceEdit.getText().toString().trim().equalsIgnoreCase(null))
                        priceEditStr = priceEdit.getText().toString().trim();
                   if(!pumpEdit.getText().toString().trim().equalsIgnoreCase("") && !pumpEdit.getText().toString().trim().equalsIgnoreCase(null))
                        pumpEditStr = pumpEdit.getText().toString().trim();

                  if(!priceEdit.getText().toString().trim().equalsIgnoreCase("") && !pumpEdit.getText().toString().trim().equalsIgnoreCase(""))
                  {
                    result = Double.parseDouble(priceEditStr) * Double.parseDouble(pumpEditStr);              
                    costView.setText(" "+result);
                  }

               }
           });

           pumpEdit.addTextChangedListener(new TextWatcher() {

               @Override
               public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

               }

               @Override
               public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

               }

               @Override
               public void afterTextChanged(Editable editable) {
                  //here, after we introduced something in the EditText we get the string from it
                   if(!priceEdit.getText().toString().trim().equalsIgnoreCase(""))
                        priceEditStr = priceEdit.getText().toString().trim();
                   if(!pumpEdit.getText().toString().trim().equalsIgnoreCase(""))
                        pumpEditStr = pumpEdit.getText().toString().trim();


                   if(!priceEdit.getText().toString().trim().equalsIgnoreCase("") && !pumpEdit.getText().toString().trim().equalsIgnoreCase(""))
                      {
                        result = Double.parseDouble(priceEditStr) * Double.parseDouble(pumpEditStr);              
                        costView.setText(" "+result);
                      }

               }
           });


           odometerEdit.addTextChangedListener(new TextWatcher() {
               @Override
               public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

               }

               @Override
               public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

               }



               @Override
               public void afterTextChanged(Editable editable) {
                  //here, after we introduced something in the EditText we get the string from it

                   if(!odometerEdit.getText().toString().trim().equalsIgnoreCase(""))
                       odmEditStr = odometerEdit.getText().toString().trim();


                  if(!odometerEdit.getText().toString().trim().equalsIgnoreCase("") && !pumpEdit.getText().toString().trim().equalsIgnoreCase("") && !lastOdm.trim().equalsIgnoreCase("") && !lastOdm.trim().equalsIgnoreCase("NA"))
                     {

                       resultCon = Double.parseDouble(odmEditStr) - Double.parseDouble(lastOdm) / Double.parseDouble(pumpEditStr);              
                       fconView.setText(" "+resultCon);
                     }

               }
           });



           cancelButton = (Button) findViewById(R.id.cancelBTN);
           cancelButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    // TODO Auto-generated method stub

                    /// Create Intent for About  and start activity
                    Intent summaryView=new Intent(getApplicationContext(),ActivityA.class);
                    startActivity(summaryView);
                    }
                });



   //Insert
        saveButton = (Button) findViewById(R.id.saveBTN);
        saveButton.setOnClickListener(new OnClickListener()
        {
            public void onClick(View v)
            {
                DBAdapter dbAdaptor = new DBAdapter(getApplicationContext());

                try
                {
                    dbAdaptor.open();
                   // String cursor = dbAdaptor.getLastOdometer();
                    String date = dateEdit.getText().toString();
                    String price = priceEdit.getText().toString();
                    String pump = pumpEdit.getText().toString();
                    String tcost = costView.getText().toString();
                    String odometer = odometerEdit.getText().toString();
                    String fcon = fconView.getText().toString();

                    if(!odometer.trim().equalsIgnoreCase(""))
                    {
                        SharedPreferences.Editor editor=sp.edit();
                        editor.putString("ODO", odometer.trim());
                        editor.commit();
                    }
                    else
                    {
                        SharedPreferences.Editor editor=sp.edit();
                        editor.putString("ODO", "NA");
                        editor.commit();
                    }

                    dbAdaptor.insertLog(date, price, pump, tcost, odometer, fcon);
                    Intent summaryView=new Intent(getApplicationContext(),ActivityA.class);
                    startActivity(summaryView);

                }
                catch(Exception e){
                    Log.d("Fuel Log", e.getMessage());
                }
                finally
                {
                    if(dbAdaptor != null)
                        dbAdaptor.close();
                }
            }
        });

    }


    public static class DatePickerFragment extends DialogFragment
    implements DatePickerDialog.OnDateSetListener {

        public EditText editText;
        DatePicker dpResult;

    public Dialog onCreateDialog(Bundle savedInstanceState) {
    // Use the current date as the default date in the picker

    final Calendar c = Calendar.getInstance();
    int year = c.get(Calendar.YEAR);
    int month = c.get(Calendar.MONTH);
    int day = c.get(Calendar.DAY_OF_MONTH);
    //return new DatePickerDialog(getActivity(), (EditSessionActivity)getActivity(), year, month, day);

    // Create a new instance of DatePickerDialog and return it
    return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    public void onDateSet(DatePicker view, int year, int month, int day) {

        dateEdit.setText(String.valueOf(day) + "/"
                + String.valueOf(month + 1) + "/" + String.valueOf(year));
        // set selected date into datepicker also


    }
    }
}