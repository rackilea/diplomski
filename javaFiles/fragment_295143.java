public void onClick(View v) {
            // TODO Auto-generated method stub

            try {

                Intent sendIntent = new Intent(Intent.ACTION_VIEW);
                sendIntent.putExtra("sms_body", "default content");
                sendIntent.setType("vnd.android-dir/mms-sms");
                startActivity(sendIntent);



            } catch (Exception e) {
                // TODO: handle exception

                Toast.makeText(getApplicationContext(),
                        "PLS Enter Again ! ", Toast.LENGTH_LONG).show();
                e.printStackTrace();
            }

        }
    });