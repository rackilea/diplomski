//if this is a new game...

//Load and parse the JSON into a local array,
//placing the stories in numerical order
ArrayList<Story> stories = getStories();

//Present story 0, since this is a new game...
TextView textView = (TextView) findViewById(R.id.story_text);
Story story = stories.get(0); 
String storyText = story.text;
textView.setText(storyText);

//The player makes his choice, so you now
//get the leads_to_story value to find out
//where to go next...
int playerChoice = 1; //whatever they choose
int nextStory = story.choices[playerChoice].leads_to_story;

//New screen loads or is initialized,
//and we load the new story...
Story story = stories.get(nextStory);
//...repeat the process...