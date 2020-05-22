private OnClickListener buttonListener = new OnClickListener() {

        ArrayList<NameValuePair> data = new ArrayList<NameValuePair>(5);

        public void onClick(View v) {
                    Intent i = getIntent();
        final String serviceType = i.getStringExtra("serviceType");
        final EditText caller = (EditText) findViewById(R.id.CallerEnter), 
            callExt = (EditText) findViewById(R.id.CallNumberEnter),
            computerName = (EditText) findViewById(R.id.ComputerNameEnter),
            location = (EditText) findViewById(R.id.LocationEnter),
            request = (EditText) findViewById(R.id.RequestEnter);

            Intent intent = new Intent(Main.this, HelpDeskEnd.class);
            final String[] email = {"target emails"};
            data.add(new BasicNameValuePair("Caller: ", textToString(caller)));
            data.add(new BasicNameValuePair("Call Ext: ", textToString(callExt)));
            data.add(new BasicNameValuePair("Computer Name: ", textToString(computerName)));
            data.add(new BasicNameValuePair("Locations: ", textToString(location)));
            data.add(new BasicNameValuePair("Request: ", textToString(request)));
            sendData(data);

            String body = data.get(0).toString() + " " + data.get(1).toString() + " " +
                    data.get(2).toString() + " " + data.get(3).toString() + " " + 
                    data.get(4).toString();
            Mail mail = new Mail("an email", "email password");
            mail.setTo(email);
            mail.setBody(body);
            mail.setFrom("an email");
            mail.setSubject(serviceType);
            try {
                mail.send();
            }
            catch (Exception e) {
                 Log.e("Send Mail", e.getMessage(), e);
            }
            intent.putExtra("serivceType", serviceType);
            startActivity(intent);
        }

    };