setContentView(R.layout.activity);

        die1 = (ImageView) findViewById(R.id.imageView1);
        die2 = (ImageView) findViewById(R.id.imageView2);
        dealButton = (Button) findViewById(R.id.dealButton);
        resetButton = (Button) findViewById(R.id.resetButton);
        resultsTextView = (TextView) findViewById(R.id.resultsTextView);
        myPointsTextView = (TextView) findViewById(R.id.myPointstTextView);
        housePointsTextView = (TextView) findViewById(R.id.housePointsTextView);
        pointsTextView = (TextView) findViewById(R.id.pointsTextView1);
        rollTextView = (TextView) findViewById(R.id.rollTextView);

          // check if app just started or is being restored from memory
          if ( savedInstanceState == null ) // the app just started running
          {
             winCount = 0; 
             loseCount = 0; 
          } 
          else 
          {
             winCount = savedInstanceState.getInt("MY_POINTS");
             loseCount = savedInstanceState.getInt("HOUSE_POINTS");

             resultsTextView.setText(savedInstanceState.getString("RESULTS"));
             pointsTextView.setText(savedInstanceState.getString("POINTS"));
             rollTextView.setText(savedInstanceState.getString("ROLL"));
          } 
...