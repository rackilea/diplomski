Bundle params = new Bundle();

params.putString("link", "your app url here");
params.putString("picture", "your img url here");
params.putString("name", "your post title");
params.putString("caption", "your subtitle");
params.putString("description", "your message");

facebook.dialog(Your Context, "feed", params, Your DialogListener);