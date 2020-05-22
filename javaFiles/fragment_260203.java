Intent in = getIntent();
    String status = in.getStringExtra(KEY_STATUS);

    //Array list of animals to display in the spinner
    List<String> list = new ArrayList<String>();
    list.add(status);