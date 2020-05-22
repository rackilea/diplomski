ImageView i = new ImageView(TimeLine.this);

User user = status.getUser();
URL = user.getProfileImageURL();

new ImageLoadTask(URL,i).execute();
LinearLayout.LayoutParams layoutParams  = new LinearLayout.LayoutParams(140,140);
i.setLayoutParams(layoutParams);

ll2.addView(i);