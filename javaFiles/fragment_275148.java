long positivePointEndTime = 0;

// In your event handler...
positivePointEndTime = System.currentTimeMillis() + 10000;

// Then in the button click handler
int scoreChange = System.currentTimeMillis() < positivePointEndTime ? 10 : -10;
currentUser.changeScore(scoreChange);