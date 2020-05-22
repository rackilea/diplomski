private void UserSuggestionQuery(AutoCompleteTextView textView) {
        ParseQuery<ParseUser> userQuery = ParseUser.getQuery();
        String input = textView.getText().toString();
        System.out.println(input);
        String recommendation = input.substring(0);
        userQuery.whereStartsWith(ParseConstants.KEY_USERNAME, recommendation);
        userQuery.findInBackground(new FindCallback<ParseUser>() {
            public void done(final List<ParseUser> parseUsers, ParseException e) {
                if (e == null) {
                    Log.d("users", "Retrieved " + parseUsers.size());

                    ParseUser[] data = parseUsers.toArray(new ParseUser[parseUsers.size()]);
                    String[] strings = new String[data.length];
                    for (int i = 0; i < data.length; i++) {
                        strings[i] = data[i].getString(ParseConstants.KEY_USERNAME).toLowerCase();
                    }
                    System.out.println(Arrays.toString(strings));
                    final ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_selectable_list_item, strings);
                    AutoCompleteTextView textView = (AutoCompleteTextView) findViewById(R.id.searchUserTextField);
                    textView.showDropDown();
                    textView.setThreshold(1);
                    textView.setAdapter(adapter);

                    // Query based on text change
                    adapter.setNotifyOnChange(true);

                }
            }
        });
    }