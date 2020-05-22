Intent i = getIntent();
        final String serviceType = i.getStringExtra("serviceType");
        final EditText caller = (EditText) findViewById(R.id.CallerEnter), 
            callExt = (EditText) findViewById(R.id.CallNumberEnter),
            computerName = (EditText) findViewById(R.id.ComputerNameEnter),
            location = (EditText) findViewById(R.id.LocationEnter),
            request = (EditText) findViewById(R.id.RequestEnter);