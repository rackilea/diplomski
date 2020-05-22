Bundle extras = new Bundle();
extras.putString("FORUM_TYPE","Review");
extras.putString("FORUM_ID",id);
extras.putString("TITLE",title);

//You have to set the bundle to intent
intent.putExtras(extras);
startActivity(intent);