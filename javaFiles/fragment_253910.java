ParseQuery<ParseObject> getQuery = ParseQuery.getQuery("Request");
        getQuery.include("user1");
        getQuery.findInBackground(new FindCallback<ParseObject>() {
            public void done(List<ParseObject> scoreList, ParseException e) {
                if (e == null) {
                    if (scoreList != null && scoreList.size() > 0) {
                        ParseObject putData = scoreList.get(0);
                        String user1=putData.getParseObject("user1").getString("fullName");
                        String user2=putData.getString("user2");
                        Log.e("USer 1", ""+user1);
                        Log.e("USer 2", ""+user2);
                    }
                }

            }
        });