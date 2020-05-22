package com.example.testmydrag;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.DatePicker;
import android.support.v4.app.FragmentActivity;
import android.app.Dialog;
import android.app.DatePickerDialog;
import android.support.v4.app.DialogFragment;

import java.util.Calendar;

public class MainActivity extends FragmentActivity {

EditText mEdit;
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    public void selectDate(View view) {

        DialogFragment newFragment = new SelectDateFragment();
        newFragment.show(getSupportFragmentManager(), "DatePicker");

    }

    public void setTheDate(int year, int month, int day) {

        mEdit = (EditText)findViewById(R.id.Text);
        mEdit.setText(month+"/"+day+"/"+year);
    }
    /*
     * Date Picker Dialog
     */
    public class SelectDateFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {

            final Calendar c = Calendar.getInstance();
            int yy = c.get(Calendar.YEAR);
            int mm = c.get(Calendar.MONTH);
            int dd = c.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog dialog = new DatePickerDialog(getActivity(),this,c.YEAR, c.MONTH, c.DATE);

            /*Calendar View if you want to Remove Set it to False*/
            dialog.getDatePicker().setCalendarViewShown(true);

            /*Spinner View if you want to Show Set it to True*/
            dialog.getDatePicker().setSpinnersShown(false);

            dialog.setTitle("Pick a date");
            return dialog;
        }
        public void onDateSet(DatePicker view, int yy, int mm, int dd) {

            setTheDate(yy, mm+1, dd);
        }
    }

}