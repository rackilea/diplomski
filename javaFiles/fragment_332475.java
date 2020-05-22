package com.example.android;

    import android.app.Activity;
    import android.content.Intent;
    import android.net.Uri;
    import android.os.Bundle;
    import android.view.View;
    import android.view.View.OnClickListener;
    import android.widget.ImageButton;
    import android.widget.TextView;

    public class App3Activity extends Activity {
        ImageButton btnPhoneOne, btnPhoneTwo, btnPhoneThree, btnPhoneFour, btnPhoneFive; 
        TextView txtNum1, txtNum2, txtNum3, txtNum4, txtNum5;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.main3);

            btnPhoneOne = (ImageButton) findViewById(R.id.btnPhone1);
            btnPhoneTwo = (ImageButton) findViewById(R.id.btnPhone2);
            btnPhoneThree = (ImageButton) findViewById(R.id.btnPhone3);
            btnPhoneFour = (ImageButton) findViewById(R.id.btnPhone4);
            btnPhoneFive = (ImageButton) findViewById(R.id.btnPhone5);

            txtNum1 = (TextView) findViewById(R.id.txtNumber1);
            txtNum2 = (TextView) findViewById(R.id.txtNumber2);
            txtNum3 = (TextView) findViewById(R.id.txtNumber3);
            txtNum4 = (TextView) findViewById(R.id.txtNumber4);
            txtNum5 = (TextView) findViewById(R.id.txtNumber5);

            String number1 = getIntent().getStringExtra("number1");
            String number2 = getIntent().getStringExtra("number2");
            String number3 = getIntent().getStringExtra("number3");
            String number4 = getIntent().getStringExtra("number4");
            String number5 = getIntent().getStringExtra("number5");

            txtNum1.setText(number1);
            txtNum2.setText(number2);
            txtNum3.setText(number3);
            txtNum4.setText(number4);
            txtNum5.setText(number5);

if(txtNum1.getText().toString().length() > 0)
    btnPhoneOne.setVisibility(View.VISIBLE);
else
    btnPhoneOne.setVisibility(View.GONE);

if(txtNum2.getText().toString().length() > 0)
    btnPhoneTwo.setVisibility(View.VISIBLE);
else
    btnPhoneTwo.setVisibility(View.GONE);

if(txtNum3.getText().toString().length() > 0)
    btnPhoneThree.setVisibility(View.VISIBLE);
else
    btnPhoneThree.setVisibility(View.GONE);

if(txtNum4.getText().toString().length() > 0)
    btnPhoneFour.setVisibility(View.VISIBLE);
else
    btnPhoneFour.setVisibility(View.GONE);

if(txtNum5.getText().toString().length() > 0)
    btnPhoneFive.setVisibility(View.VISIBLE);
else
    btnPhoneFive.setVisibility(View.GONE);



            btnPhoneOne.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent callIntent = new Intent(Intent.ACTION_DIAL);
                    callIntent.setData(Uri.parse("tel:" + txtNum1.getText()));
                    startActivity(callIntent);
                }
            });

            btnPhoneTwo.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent callIntent = new Intent(Intent.ACTION_DIAL);
                    callIntent.setData(Uri.parse("tel:" + txtNum2.getText()));
                    startActivity(callIntent);
                }
            });

            btnPhoneThree.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent callIntent = new Intent(Intent.ACTION_DIAL);
                    callIntent.setData(Uri.parse("tel:" + txtNum3.getText()));
                    startActivity(callIntent);
                }
            });

            btnPhoneFour.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent callIntent = new Intent(Intent.ACTION_DIAL);
                    callIntent.setData(Uri.parse("tel:" + txtNum4.getText()));
                    startActivity(callIntent);
                }
            });

            btnPhoneFive.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent callIntent = new Intent(Intent.ACTION_DIAL);
                    callIntent.setData(Uri.parse("tel:" + txtNum5.getText()));
                    startActivity(callIntent);
                }
            });
        }
    }