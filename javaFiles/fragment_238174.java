public void updateTweetList(){

        // clearing the lists to avoid duplicate entries
        userOwnTweets.clear();
        userOwnTweetsDate.clear();
        getUserOwnTweetsObjectId.clear();



        // just backend code to get the tweets of the user
        ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("Tweet");
        query.whereEqualTo("username", ParseUser.getCurrentUser().getUsername());
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, ParseException e) {

                if (e == null && objects.size() > 0){

                    for (ParseObject object : objects){

                        String tempString = object.getString("tweet");
                        tempString = tempString.substring(0, Math.min(tempString.length(), 20));
                        tempString+="...";

                        // adding them to the arraylists
                        userOwnTweets.add(tempString);
                        userOwnTweetsDate.add(object.getString("date"));
                        getUserOwnTweetsObjectId.add(object.getObjectId());
                    }

                   // updating the customlistview for datastatechanged
                   customArrayAdapter.notifyDataSetChanged();
                }
            }
        });


    }