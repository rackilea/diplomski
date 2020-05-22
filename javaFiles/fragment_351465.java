package com.eqsec.csaba;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class EqsecActivity extends Activity {
/** Called when the activity is first created. */

Button solve;
EditText vA, vB, vC;
TextView solution;
int discriminant, iA, iB, iC;


@Override
public void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.main);
solve = (Button) findViewById(R.id.bSolve);
vA = (EditText) findViewById(R.id.etA);
vB = (EditText) findViewById(R.id.etB);
vC = (EditText) findViewById(R.id.etC);
solution = (TextView) findViewById(R.id.solution);

solve.setOnClickListener(new View.OnClickListener() {

        public void onClick(View v) {
            // TODO Auto-generated method stub
            try{
            String A = vA.getText().toString();
            iA = Integer.parseInt(A);
           String B = vB.getText().toString();
            iB = Integer.parseInt(B);
            String C = vC.getText().toString();
            iC = Integer.parseInt(C);


        solution.setText("Yout total is " + iA);
            }catch (NumberFormatException e) {
                e.printStackTrace();
            }


        }
    });


          }
   }