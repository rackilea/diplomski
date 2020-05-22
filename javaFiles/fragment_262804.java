class RegisterUser extends AsyncTask<String, Integer, JsonResponseFromserver>{
            ProgressDialog loading;
            //RegisterUserClass ruc = new RegisterUserClass();
            RequestHandler ruc = new RequestHandler();

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(Register.this, "Please Wait",null, true, true);
            }

            @Override
            protected void onPostExecute(JsonResponseFromserver s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(getApplicationContext(),"Successfully Registered..!!",Toast.LENGTH_LONG).show();
                editTextFname.setText("");
                editTextLname.setText("");
                editTextDob.setText("");
                editTextPob.setText("");
                editTextMobile.setText("");
                editTextEmail.setText("");
                editTextPin.setText("");

                Intent i = new Intent(Register.this,UserProfile.class);
                i.putExtra("s", s.fullname);
                startActivity(i);
            }

            @Override
            protected JsonResponseFromserver doInBackground(String... params) {

                HashMap<String, String> data = new HashMap<String,String>();
                data.put("salutation",params[0]);
                data.put("category",params[1]);
                data.put("fname",params[2]);
                data.put("lname",params[3]);
                data.put("dob",params[4]);
                data.put("pob",params[5]);
                data.put("mobile",params[6]);
                data.put("email", params[7]);
                data.put("country",params[8]);
                data.put("state",params[9]);
                data.put("city",params[10]);
                data.put("pin",params[11]);


                JsonResponseFromserver result = ruc.sendPostRequest(REGISTER_URL,data);

                return  result;
            }
        }