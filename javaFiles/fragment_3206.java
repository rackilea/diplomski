String answer = "";
    Bundle bundle = getIntent().getExtras();

    if (bundle != null) {
        if (bundle.containsKey("KEY_ANSWER"))
            answer = bundle.getString("KEY_ANSWER"); 
    }

    Log.d("SUCCESS", "answer: " + answer);

    TextView textViewDisplayResult = (TextView) findViewById(R.id.text_view_display_result);
    textViewDisplayResult.setText(answer);