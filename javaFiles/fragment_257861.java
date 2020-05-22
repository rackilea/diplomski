Intent intent = new Intent(SecondActivity.this, MainActivity.class);
for (int i = 0; i<userlist.size(); i++)
     intent.putExtra("userlist_"+i , userlist.get(i));
intent.putExtra("userlist_size" , userlist.size());
startActivity(intent);
finish();