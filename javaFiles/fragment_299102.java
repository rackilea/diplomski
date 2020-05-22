//Make the bar disappear after URL is loaded, and changes string to Loading...
MyActivity.setTitle("Loading...");
MyActivity.setProgress(progress * 100); //Make the bar disappear after URL is loaded

// Return the app name after finish loading
    if(progress == 100)
         MyActivity.setTitle(R.string.app_name);