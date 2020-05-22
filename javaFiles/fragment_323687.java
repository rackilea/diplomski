package com.example.android.quiz_app_androidmodule;

import android.support.v7.app.AppCompatActivity;import android.os.Bundle;
import android.os.AsyncTask;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;



public class MainActivity extends AppCompatActivity {
ConnectionClass connectionClass;
TextView Question, Score;
Button btnlogin, btnA, btnB, btnC, btnStart;

DoLogin doLogin ;


@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    connectionClass = new ConnectionClass();

    btnlogin = (Button) findViewById(R.id.btnStart);

    btnA = (Button) findViewById(R.id.button1);
    btnB = (Button) findViewById(R.id.button2);
    btnC = (Button) findViewById(R.id.button3);
    Question = (TextView) findViewById(R.id.textViewQuestion);
    Score = (TextView) findViewById(R.id.textViewScore);

    doLogin.execute(id);

    btnlogin.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        //Make sure your first id is 1;
            id = id+1;
            dologin = = new DoLogin()
            doLogin.execute(id);

            btnA.setVisibility(View.VISIBLE);
            btnB.setVisibility(View.VISIBLE);
            btnC.setVisibility(View.VISIBLE);
            Question.setVisibility(View.VISIBLE);
            Score.setVisibility(View.VISIBLE);
            btnlogin.setVisibility(View.GONE);


        }
    });


}






String z = "";
String zA = "";
String zB="";
String zC="";
int id = 0;
int points;

public class DoLogin extends AsyncTask<String, String, String> {

    Boolean isSuccess = false;


    @Override
    protected void onPostExecute(String r) {


        if (isSuccess) {
          Question.setText(z);
            btnA.setText(zA);
            btnB.setText(zB);
            btnC.setText(zC);
        }

    }

    @Override
    protected String doInBackground(String... params) {

    String id = params[0];

        try {
            Connection con = connectionClass.CONN();
            if (con == null) {
                z = "Error in connection with SQL server";
            } else {
                String query = "select question from Question where quizID >= "+id;
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(query);

                String queryA = "select optionOne from Options where quizID >= "+id;
                Statement stmtA = con.createStatement();
                ResultSet rsA = stmtA.executeQuery(queryA);

                String queryB = "select optionTwo from Options where quizID >= "+id;
                Statement stmtB = con.createStatement();
                ResultSet rsB = stmtB.executeQuery(queryB);


                String queryC = "select optionThree from Options where quizID >= "+id;
                Statement stmtC = con.createStatement();
                ResultSet rsC = stmtC.executeQuery(queryC);
                if (rs.next() | rsA.next() | rsB.next() | rsC.next()) {
                    z = rs.getString(id).toString();
                    zA=rsA.getString(id).toString();
                    zB=rsB.getString(id).toString();
                    zC=rsC.getString(id).toString();
                    isSuccess = true;
                } 
                  else {
                    z = "Invalid Credentials";
                    isSuccess = false;
                }
            }
        } catch (Exception ex) {
            isSuccess = false;
            z = "Exceptions";
        }
       return z;
    }

}
}