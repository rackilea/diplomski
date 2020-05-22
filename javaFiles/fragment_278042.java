if (type.equals("RAW_TYPE")) {
        rhs1 = new RawHttpSensor();
        temperature = (TextView) findViewById(R.id.temperature);
        rhs1.registerListener(this);
        rhs1.getTemperature();
    }